package com.prokhorenko.clientSide;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    public static String validationRequest() throws InvalidUsernameOrPassException, ForbiddenCharacterException {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Enter username");
        username = scanner.nextLine();
        if (username.equals("")) {
            throw new InvalidUsernameOrPassException();
        }
        System.out.println("Enter password");
        password = scanner.nextLine();
        if (password.equals("")) {
            throw new InvalidUsernameOrPassException();
        }
        String request = username + "|" + password;
        forbiddenCharacterCheck(request, 1);
        return request;
    }

    public static String userAddingRequest() throws InputMismatchException, InvalidUsernameOrPassException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Create Admin\n2-Create User");
        int answer = scanner.nextInt();
        try {
            if (answer == 1) {
                return "-newUser|Admin|" + validationRequest();
            } else if (answer == 2) {
                return "-newUser|User|" + validationRequest();
            } else return "Incorrect input";
        } catch (ForbiddenCharacterException e) {
            System.out.println("character '|' is not allowed here");
            return "Incorrect input";
        }


    }

    public static String menu(boolean isAdmin) {
        int response;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("0-Quit\n1-Show all student files");
            if (isAdmin) {
                System.out.println("2-Edit a student file\n3-Create a new student file\n4-Add a new user");
            }

            try {
                response = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {

                System.out.println("Incorrect input");
            }
        }
        switch (response) {
            case 0:
                return "-quit";

            case 1:
                System.out.println("Waiting for response to request...");
                return "-show";
            case 2:
                if (isAdmin) {
                    try {
                        System.out.println("Waiting for response to request...");
                        String request = editionRequest();
                        forbiddenCharacterCheck(request, 4);
                        return "-edit|" + request;
                    } catch (IncorrectNameInputException e) {
                        System.out.println("Incorrect name input");
                        return "Incorrect input";
                    } catch (IncorrectFacultyInputException e) {
                        System.out.println("Incorrect faculty input");
                        return "Incorrect input";
                    } catch (IncorrectGroupNumInputException e) {
                        System.out.println("Incorrect group number input");
                        return "Incorrect input";
                    } catch (IncorrectYearInputException e) {
                        System.out.println("Incorrect year input");
                        return "Incorrect input";
                    } catch (ForbiddenCharacterException e) {
                        System.out.println("character '|' is not allowed here");
                        return "Incorrect input";
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input");
                        return "Incorrect input";
                    }
                } else return "Incorrect input";

            case 3:
                if (isAdmin) {
                    try {
                        System.out.println("Waiting for response to request...");
                        String request = creationRequest();
                        forbiddenCharacterCheck(request, 3);
                        return "-create|" + creationRequest();
                    } catch (IncorrectNameInputException e) {
                        System.out.println("Incorrect name input");
                        return "Incorrect input";
                    } catch (IncorrectFacultyInputException e) {
                        System.out.println("Incorrect faculty input");
                        return "Incorrect input";
                    } catch (IncorrectGroupNumInputException e) {
                        System.out.println("Incorrect group number input");
                        return "Incorrect input";
                    } catch (IncorrectYearInputException e) {
                        System.out.println("Incorrect year input");
                        return "Incorrect input";
                    } catch (ForbiddenCharacterException e) {
                        System.out.println("symbol | is not allowed here");
                        return "Incorrect input";
                    }
                } else return "Incorrect input";

            case 4:
                if (isAdmin) {
                    System.out.println("Waiting for response to request...");
                    try {
                        return userAddingRequest();
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input");
                        return "Incorrect input";
                    } catch (InvalidUsernameOrPassException e) {
                        System.out.println("Incorrect username or password");
                        return "Incorrect input";
                    }

                } else return "Incorrect input";
            default:
                return "Incorrect input";
        }
    }

    public static String editionRequest() throws IncorrectFacultyInputException, IncorrectNameInputException,
            IncorrectGroupNumInputException, IncorrectYearInputException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of a student file");
        int id = scanner.nextInt();
        return id + "|" + creationRequest();
    }


    public static String creationRequest() throws IncorrectNameInputException, IncorrectFacultyInputException, IncorrectGroupNumInputException, IncorrectYearInputException {
        Scanner scanner = new Scanner(System.in);
        String name;
        String faculty;
        String groupNumber;
        String yearOfEnrollment;
        System.out.println("Enter name");
        name = scanner.nextLine();
        if (!name.matches("\\D+")) {
            throw new IncorrectNameInputException();
        }
        System.out.println("Enter faculty");
        faculty = scanner.nextLine();
        if (!faculty.matches("\\D+")) {
            throw new IncorrectFacultyInputException();
        }
        System.out.println("Enter group number");
        groupNumber = scanner.nextLine();
        if (!groupNumber.matches("\\d+")) {
            throw new IncorrectGroupNumInputException();
        }
        System.out.println("Enter year of enrolment");
        yearOfEnrollment = scanner.nextLine();
        if (!yearOfEnrollment.matches("\\d+")) {
            throw new IncorrectYearInputException();
        }
        return name + "|" + faculty + "|" + groupNumber + "|" + yearOfEnrollment;
    }

    //поскольку символ | используется в запросах нужна проверка его количества в запросе
    public static void forbiddenCharacterCheck(String s, int number) throws ForbiddenCharacterException {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '|')
                count++;
        }
        if (count != number)
            throw new ForbiddenCharacterException();
    }

    public static void main(String[] args) throws InterruptedException, IOException {

// запускаем подключение сокета по известным координатам и инициализируем приём сообщений с консоли клиента
        Socket socket = new Socket("localhost", 8000);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        System.out.println("Client connected to socket.");
        System.out.println();
        System.out.println("Client writing channel = oos & reading channel = ois initialized.");

// проверяем живой ли канал и работаем если живой
        while (!socket.isOutputShutdown()) {

            // посылаем запрос серверу на инициализацию пользователя
            String validationResponse;
            try {
                validationResponse = validationRequest();
            } catch (InvalidUsernameOrPassException e) {
                System.out.println("Incorrect username or password");
                continue;
            } catch (ForbiddenCharacterException e) {
                System.out.println("character '|' is not allowed here");
                continue;
            }
            out.writeUTF(validationResponse);
            out.flush();
            System.out.println("Waiting for response to request...");
            String response;
            Thread.sleep(2000);

            //получаем ответ от сервера вида (имя пользователя|является ли админом), либо сообщение об ошибке
            response = in.readUTF();
            if (response.equals("-error")) {
                System.out.println("Incorrect username or password");
                continue;
            }

            String[] ans = response.split("\\|");
            System.out.println("Hello " + ans[0]);
            boolean isAdmin = Boolean.parseBoolean(ans[1]);
            //если валидация произведена успешно - меню выбора запроса к серверу
            while (true) {
                response = menu(isAdmin);
                if (response.equals("Incorrect input")) {
                    System.out.println(response);
                    continue;
                } else {
                    out.writeUTF(response);//отправляем запрос
                    out.flush();
                }
                Thread.sleep(2000);
                String entry = in.readUTF();//получаем ответ
                if (entry.equals("-quit")) {   //проверка условие отключения от сервера и заершения программы
                    System.out.println("Client is disconnected");
                    System.exit(0);
                }
                System.out.println(entry);//вывод ответа на запрос
            }
        }

    }

    //ошибки ввода
    private static class IncorrectNameInputException extends Throwable {
    }

    private static class IncorrectFacultyInputException extends Throwable {
    }

    private static class IncorrectGroupNumInputException extends Throwable {
    }

    private static class IncorrectYearInputException extends Throwable {
    }

    private static class InvalidUsernameOrPassException extends Throwable {
    }

    private static class ForbiddenCharacterException extends Throwable {
    }
}
