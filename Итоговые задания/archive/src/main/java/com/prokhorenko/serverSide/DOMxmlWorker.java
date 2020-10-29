package com.prokhorenko.serverSide;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMxmlWorker {


    public static Archive parseArchive() {
        Archive archive = new Archive();
        String name = "";
        String faculty = "";
        String groupNum = "-1";
        String year = "-1";
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/java/com/prokhorenko/resources/archive-info");

            Node root = document.getDocumentElement();

            NodeList dossiers = root.getChildNodes();
            for (int i = 0; i < dossiers.getLength(); i++) {
                Node dossier = dossiers.item(i);
                if (dossier.getNodeType() != Node.TEXT_NODE) {
                    NodeList dossierProps = dossier.getChildNodes();
                    for (int j = 0; j < dossierProps.getLength(); j++) {
                        Node dossierProp = dossierProps.item(j);
                        if (dossierProp.getNodeType() != Node.TEXT_NODE) {
                            if (dossierProp.getNodeName().equals("name")) {
                                name = dossierProp.getChildNodes().item(0).getTextContent();
                            }
                            if (dossierProp.getNodeName().equals("faculty")) {
                                faculty = dossierProp.getChildNodes().item(0).getTextContent();
                            }
                            if (dossierProp.getNodeName().equals("groupNum")) {
                                groupNum = dossierProp.getChildNodes().item(0).getTextContent();
                            }
                            if (dossierProp.getNodeName().equals("year")) {
                                year = dossierProp.getChildNodes().item(0).getTextContent();
                                try {
                                    archive.addStudentFile(new Student(name, faculty,
                                            Integer.parseInt(groupNum), Integer.parseInt(year)));
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < archive.getStudents().size(); i++) {
            archive.getStudents().get(i).setId(i + 1);
        }

        return archive;
    }

    public static ArrayList<User> parseUsers(Archive archive) {
        ArrayList<User> users = new ArrayList<>();
        String userName = "";
        String pass = "";
        Boolean isAdmin = false;

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/java/com/prokhorenko/resources/users");

            Node root = document.getDocumentElement();

            NodeList dossiers = root.getChildNodes();
            for (int i = 0; i < dossiers.getLength(); i++) {
                Node dossier = dossiers.item(i);
                if (dossier.getNodeName().equals("Admin")) {
                    isAdmin = true;
                }
                if (dossier.getNodeType() != Node.TEXT_NODE) {
                    NodeList dossierProps = dossier.getChildNodes();
                    for (int j = 0; j < dossierProps.getLength(); j++) {
                        Node dossierProp = dossierProps.item(j);
                        if (dossierProp.getNodeType() != Node.TEXT_NODE) {
                            if (dossierProp.getNodeName().equals("username")) {
                                userName = dossierProp.getChildNodes().item(0).getTextContent();
                            }
                            if (dossierProp.getNodeName().equals("password")) {
                                pass = dossierProp.getChildNodes().item(0).getTextContent();
                                if (!isAdmin) {
                                    users.add(new User(userName, pass, archive));
                                } else {
                                    users.add(new Admin(userName, pass, archive));
                                }
                                isAdmin = false;
                            }

                        }
                    }
                }
            }


        } catch (
                ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (
                SAXException ex) {
            ex.printStackTrace();
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

        return users;
    }


    public static void writeStudents(Archive archive) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();

            Element rootElement =
                    doc.createElement("Archive");

            doc.appendChild(rootElement);

            for (Student student : archive.getStudents()) {
                rootElement.appendChild(getStudent(doc, student));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file =
                    new StreamResult(new File("src/main/java/com/prokhorenko/resources/archive-info"));

            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getStudent(Document doc, Student student) {
        Element element = doc.createElement("Student");

        element.setAttribute("id", String.valueOf(student.getId()));

        element.appendChild(getElements(doc, element, "name", student.getName()));

        element.appendChild(getElements(doc, element, "faculty", student.getFaculty()));

        element.appendChild(getElements(doc, element, "groupNum",
                String.valueOf(student.getGroupNumber())));

        element.appendChild(getElements(doc, element, "year",
                String.valueOf(student.getYearOfEnrollment())));

        return element;
    }


    // утилитный метод для создание нового узла XML-файла
    private static Node getElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public static void writeUsers(ArrayList<User> users) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElement("Users");
            doc.appendChild(rootElement);

            for (User user : users) {
                rootElement.appendChild(getUser(doc, user));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file =
                    new StreamResult(new File("src/main/java/com/prokhorenko/resources/users"));

            transformer.transform(source, file);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод для создания нового узла XML-файла
    private static Node getUser(Document doc, User user) {
        Element element = null;
        if (user instanceof Admin) {
            element = doc.createElement("Admin");
        } else {
            element = doc.createElement("User");
        }

        element.appendChild(getElements(doc, element, "username", user.getUsername()));

        element.appendChild(getElements(doc, element, "password", user.getPassword()));

        return element;
    }


}
