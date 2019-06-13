package dao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.dal.ContactDAO;
import dao.domain.Address;
import dao.domain.Contact;

public class App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String... args) {
		dspMainMenu();
	}

	public static void dspMainMenu() {
		int response;
		boolean first = true;
		do {
			if (!first) {
				System.out.println("***********************************************");
				System.out.println("* Mauvais choix, merci de recommencer !       *");
				System.out.println("***********************************************");
			}
			System.out.println("**************************************");
			System.out.println("*****************Menu*****************");
			System.out.println("* 1 - Ajouter un contact             *");
			System.out.println("* 2 - Modifier un contact            *");
			System.out.println("* 3 - Supprimer un contact           *");
			System.out.println("* 4 - Lister les contacts            *");
			System.out.println("* 5 - Rechercher un contact          *");
			System.out.println("* 6 - Quitter                       *");
			System.out.println("**************************************");
			System.out.print("*Votre choix : ");
			try {
				response = sc.nextInt();
			} catch (InputMismatchException e) {
				response = -1;
			} finally {
				sc.nextLine();
			}
			first = false;
		} while (1 > response || 6 < response);
		switch (response) {
		case 1:
			addContact();
			break;
		case 2:
			editContact();
			break;
		case 3:
			deleteContact();
			break;
		case 4:
			dspContacts(true);
			break;
		case 5:
			// TODO
			break;
		}
	}

	public static void addContact() {
		System.out.println("**************************************");
		System.out.println("**********Ajout d'un contact**********");
		Contact contact = new Contact();
		System.out.print("Entrer le prénom :");
		contact.setFirstName(sc.nextLine());
		System.out.print("Entrer l'email :");
		contact.setEmail(sc.nextLine());
		Address address = new Address("rue de la soif");
		contact.setAddress(address);
		ContactDAO dao = new ContactDAO();
		try {
			dao.createContact(contact);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Nouveau contact ajouté ...");
	}

	public static void editContact() {
		System.out.println("*********************************************");
		System.out.println("**********Modification d'un contact**********");
		dspContacts(false);
		System.out.print("Entrer l'identifiant du contact : ");
		String id = sc.nextLine();
	}

	public static void deleteContact() {
		System.out.println("*********************************************");
		System.out.println("***********Suppression d'un contact**********");
		dspContacts(false);
		System.out.print("Entrer l'identifiant du contact : ");
		String id = sc.nextLine();

	}

	public static void dspContact(Contact contact) {
		System.out.println(contact);
	}

	public static void dspContacts(boolean dspHeader) {
		if (dspHeader) {
			System.out.println("**************************************");
			System.out.println("********Liste de vos contacts*********");
		}
		// TODO
		System.out.println("**************************************");
	}
}
