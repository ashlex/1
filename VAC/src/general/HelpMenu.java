package general;


public interface HelpMenu {
	
	/**
	 * @return Возращает строку для раздела помощи и описания программы
	 */
	String getHelp();
	/**
	 * @return Возращает отформатированую строку с информацией о самой программе
	 */
	String getAbout();
	
}
