package gr.aueb.cf.schoolapp;

import java.awt.EventQueue;

public class Main {
	
	
	private static Menu menu;
	private static TeachersSearchForm searchForm;
	private static TeachersInsertForm teachersInsertForm;
	private static TeachersUpdateDeleteForm teachersUpdateDeleteForm;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu = new Menu();
					menu.setVisible(true);
					
					searchForm = new TeachersSearchForm();
					searchForm.setVisible(false);
					
					teachersInsertForm = new TeachersInsertForm();
					teachersInsertForm.setVisible(false);
					
					teachersUpdateDeleteForm = new TeachersUpdateDeleteForm();
					teachersUpdateDeleteForm.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Menu getMenu() {
		return menu;
	}

	public static TeachersSearchForm getSearchForm() {
		return searchForm;
	}

	public static TeachersInsertForm getTeachersInsertForm() {
		return teachersInsertForm;
	}

	public static TeachersUpdateDeleteForm getTeachersUpdateDeleteForm() {
		return teachersUpdateDeleteForm;
	}
	
	
}
