package com.prokhorenko.serverSide;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Server {


    public static User validation(ArrayList<User> users, String entry) {
        String[] arr = entry.split("\\|");
        for (User user : users) {
            if (user.getUsername().equals(arr[0]) && user.getPassword().equals(arr[1])) {
                return user;
            }
        }
        throw new NullPointerException();
    }

    public static String showRequest(Archive archive) {
        String answer = "";
        for (Student student : archive.getStudents()) {
            answer += "Id: " + student.getId() + " Name: " + student.getName() + " Faculty: " + student.getFaculty() +
                    " Group Number: " + student.getGroupNumber() + " Year of enrolment " + student.getYearOfEnrollment()
                    + "\n";
        }
        return answer;
    }

    public static void creatingRequest(Archive archive, String[] entryArray) throws NumberFormatException {
        archive.getStudents().add(new Student(entryArray[1], entryArray[2], Integer.parseInt(entryArray[3]),
                Integer.parseInt(entryArray[4])));
        System.out.println();
        archive.getStudents().get(archive.getStudents().size() - 1).setId(archive.getStudents().size());
        DOMxmlWorker.writeStudents(archive);
        System.out.println("A new student file was created");
    }

    public static void editionRequest(Archive archive, String[] entryArray) throws NumberFormatException,
            NullPointerException, IndexOutOfBoundsException {

        int id = Integer.parseInt(entryArray[1]);
        int index = id - 1;
        archive.getStudents().remove(index);

        Student student = new Student(entryArray[2], entryArray[3],
                Integer.parseInt(entryArray[4]), Integer.parseInt(entryArray[5]));
        student.setId(id);
        archive.getStudents().add(index, student);
        Collections.sort(archive.getStudents());
        DOMxmlWorker.writeStudents(archive);
        System.out.println("The student file was edited");
    }


    public static void userAddingRequest(Archive archive, ArrayList<User> users, String[] entryArray) {
        if (entryArray[1].equals("Admin")) {
            users.add(new Admin(entryArray[2], entryArray[3], archive));
        } else {
            users.add(new User(entryArray[2], entryArray[3], archive));
        }
        DOMxmlWorker.writeUsers(users);
        System.out.println("User " + entryArray[2] + "was added");
    }


    public static void main(String[] args) throws InterruptedException {


        Archive archive = DOMxmlWorker.parseArchive();
        ArrayList<User> users = DOMxmlWorker.parseUsers(archive);


        while (true) {
            System.out.println("Server is waiting");
            User user = null;


//  стартуем сервер на порту 8000

            try (ServerSocket server = new ServerSocket(8000)) {
// становимся в ожидание подключения к сокету под именем - "client" на серверной стороне
                Socket client = server.accept();

// после хэндшейкинга сервер ассоциирует подключающегося клиента с этим сокетом-соединением
                System.out.println("Connection accepted.");

// инициируем каналы для  общения в сокете, для сервера

// канал записи в сокет
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                System.out.println("DataOutputStream  created");

                // канал чтения из сокета
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println("DataInputStream created");

// начинаем диалог с подключенным клиентом в цикле, пока сокет не закрыт
                while (!client.isClosed()) {

                    System.out.println("Server reading from channel");

// сервер ждёт в канале чтения (inputstream) получения данных клиента

                    String entry = in.readUTF();

//проверка на валидацию: если она не произошла, то запрос от клиента - запрос на валидацию

                    if (user == null) {
                        try {
                            user = validation(users, entry);
                            out.writeUTF(user.getUsername() + "|" + (user instanceof Admin));
                            out.flush();
                            Thread.sleep(2000);
                            System.out.println("User " + user.getUsername() + " connected");
                            continue;
                        } catch (NullPointerException ex) {
                            out.writeUTF("-error");
                            out.flush();
                            Thread.sleep(2000);
                            System.out.println("Incorrect input");
                            continue;
                        }
                    }

//разбираем запрос от клиента на массив String, где каждый элемент-парметр запроса, первый элемент отвечает за то,
// какой метод будет вызван

                    String[] entryArray = entry.split("\\|");//
                    if (entryArray[0].equals("-quit")) {
                        System.out.println("Client initialize connections suicide ...");
                        out.writeUTF(entry);
                        out.flush();
                        Thread.sleep(2000);
                        break;
                    } else if (entryArray[0].equals("-show")) {
                        out.writeUTF(showRequest(archive));
                        out.flush();
                        Thread.sleep(2000);
                        System.out.println("Show");
                    } else if (entryArray[0].equals("-edit")) {
                        try {
                            editionRequest(archive, entryArray);
                            out.writeUTF("The student file was edited");
                            out.flush();
                            Thread.sleep(2000);
                        } catch (NumberFormatException ex) {
                            out.writeUTF("-Error\n");
                            out.flush();
                            Thread.sleep(2000);
                            ex.printStackTrace();
                        } catch (NullPointerException ex) {
                            out.writeUTF("-Error");
                            out.flush();
                            Thread.sleep(2000);
                            ex.printStackTrace();
                        } catch (IndexOutOfBoundsException ex) {
                            out.writeUTF("-Error\nIncorrect id!");
                            out.flush();
                            Thread.sleep(2000);
                            ex.printStackTrace();
                        }
                    } else if (entryArray[0].equals("-create")) {
                        try {
                            creatingRequest(archive, entryArray);
                            out.writeUTF("The student file was created");
                            out.flush();
                            Thread.sleep(2000);
                        } catch (NumberFormatException ex) {
                            out.writeUTF("-Error");
                            out.flush();
                            Thread.sleep(2000);
                            ex.printStackTrace();
                        }
                    } else if (entryArray[0].equals("-newUser")) {
                        userAddingRequest(archive, users, entryArray);
                        out.writeUTF("A new user was added");
                        out.flush();
                        Thread.sleep(2000);
                    } else {
                        out.writeUTF("-Error");
                        out.flush();
                        Thread.sleep(2000);
                        System.out.println("Error");
                    }

                }


// если пользователь отключился - закрываем все каналы, после чего сервер возвращается в режим ожидания клиента
                System.out.println("Client disconnected");
                System.out.println("Closing connections & channels.");

                // закрываем сначала каналы сокета !
                in.close();
                out.close();

                // потом закрываем сам сокет общения на стороне сервера!
                client.close();

                // потом закрываем сокет сервера который создаёт сокеты общения
                // для возможности поставить этот серверный сокет обратно в ожидание нового подключения

                System.out.println("Closing connections & channels - DONE.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

