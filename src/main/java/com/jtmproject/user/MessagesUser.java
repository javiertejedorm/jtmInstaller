package com.jtmproject.user;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class store all messages for users.
 * @author Javier Tejedor
 * @thnx Pello Altadill
 */
public class MessagesUser {

	private String versionJtmInstaller;
	private String search;
	private String open;
	private String logout;
	private String login;
	private String install;
	private String modified;
	private String errorOpenFile;
	private String copyright;
	private String scanAv;
	private String oneClickInstall;
	private String normalInstall;
	private String osIncompatible;
	private String errorSpace;
	private String next;
	private String previous;
	private String cancel;
	private String welcome;
	private String configuration;
	private String installTo;
	private String change;
	private String addShortcutDesktop;
	private String addShortcutStartMenu;
	private String selectDirectory;
	private String installCurrentUser;
	private String installAllUsers;
	private String associateExtension;
	private String exit;
	private String favorites;
	private String serverConfiguration;
	private String file;
	private String user;
	private String configurationMenu;
	private String enterIP;
	private String password;
	private String accept;
	private String remove;
	private String youMustLoginFirst;
	private String invalidServer;
	private String loginError;
	private String informationProgram;
	private String nameOfTheProgram;
	private String totalFiles;
	private String urlDownloadFile;
	private String sizeAfterInstall;
	private String osSupported;
	private String defaultFolder;
	private String author;
	private String localization;
	private String description;
	private String developer;
	private String productCode;
	private String productName;
	private String technicalSupportTelephone;
	private String technicalSupportUrl;
	private String version;
	private String visitJtmPlace;
	private String publicServerListNotFound;
	private String connectedTo;
	private String programInstalled;
	private String doYouWantToRun;
	private String accessing;
	private String saveJtm;
	private String saved;
	private String unzipping;
	private String downloading;
	private String creatingFolders;
	private String addingDesktopShortcuts;
	private String addingWindowsStartup;
	private String addingRegistryUninstaller;
	private String addingRegistryAppPaths;
	private String associatingExtension;
	private String thereAreOthersInstalls;	
	private String thereIsNotInternetConnection;
	private String installationCancelled;
	private String settings;
	private String publicServers;
	private String cleaning;
	private String security;
	private String showInformationCertificate;
	private String keepUserSession;
	private String cleanTemporalFolder;
	private String removeJtmAfterInstall;
	private String newVersionAvailable;
	private String notifyNewVersion;
	private String errorDecompress;
	private String errorDownload;
	private String errorFindPath;
	private String help;
	private String helpContent;
	private String about;
	private String loggingStart;
	private String addShortcuts;
	private String searchProgram;
	private String versionCorrect;
	private String checkNewVersionWhenFailOpen;
	private String proxyConfiguration;
	private String preferences;
	private String network;
	private String serverPublicList;
	
	private static MessagesUser mU;

	
	/**
	 * returns an object of this class (Singleton Class)
	 * @return
	 */
	public static MessagesUser getMU() {
		if(mU == null){
			mU = new MessagesUser();
		}
		return mU;
	}

	/**
	 * constructor
	 */
	public MessagesUser(){
		Locale locale = Locale.getDefault();
		//gets country and language from the system
		String languageCode = System.getProperty("user.language");
		String countryCode = System.getProperty("user.country");

		locale = new Locale(languageCode, countryCode);

		ResourceBundle messagesUser = ResourceBundle.getBundle("i18n.Messages", locale);

		addAllMessages(messagesUser);
	}


	/**
	 * this method gets all messages from .properties in bin folder
	 * @param messagesUser
	 */
	private void addAllMessages(ResourceBundle messagesUser){
		versionJtmInstaller = messagesUser.getString("version_jtminstaller");
		search = messagesUser.getString("search");
		open = messagesUser.getString("open");
		logout = messagesUser.getString("logout");
		login = messagesUser.getString("login");
		install = messagesUser.getString("install");
		modified = messagesUser.getString("modified");
		errorOpenFile = messagesUser.getString("file_open_error");
		copyright = messagesUser.getString("copyright");
		scanAv = messagesUser.getString("scan_av");
		oneClickInstall = messagesUser.getString("already_install");
		normalInstall = messagesUser.getString("normal_installation");
		osIncompatible = messagesUser.getString("operating_system_incompatible");
		errorSpace = messagesUser.getString("space_error");
		next = messagesUser.getString("next");
		previous = messagesUser.getString("previous");
		cancel = messagesUser.getString("cancel");
		welcome = messagesUser.getString("welcome");
		configuration = messagesUser.getString("configuration");
		installTo = messagesUser.getString("install_to");
		change = messagesUser.getString("change");
		addShortcutDesktop = messagesUser.getString("add_shortcut_desktop");
		addShortcutStartMenu = messagesUser.getString("add_shortcut_start_menu");
		selectDirectory = messagesUser.getString("select_a_directory");
		installCurrentUser = messagesUser.getString("install_current_user");
		installAllUsers = messagesUser.getString("install_all_users");
		associateExtension = messagesUser.getString("associate_extension");
		exit = messagesUser.getString("exit");
		favorites = messagesUser.getString("favorites");
		serverConfiguration = messagesUser.getString("server_configuration");
		file = messagesUser.getString("file");
		user = messagesUser.getString("user");
		configurationMenu = messagesUser.getString("configuration_menu");
		enterIP = messagesUser.getString("enter_ip");
		password = messagesUser.getString("password");
		accept = messagesUser.getString("accept");
		remove = messagesUser.getString("remove");
		youMustLoginFirst = messagesUser.getString("you_must_login_first");
		invalidServer = messagesUser.getString("invalid_server");
		loginError = messagesUser.getString("login_error");
		informationProgram = messagesUser.getString("information_about_program");
		nameOfTheProgram = messagesUser.getString("name_program");
		totalFiles =  messagesUser.getString("total_files");
		urlDownloadFile = messagesUser.getString("url_donwload_file");
		sizeAfterInstall = messagesUser.getString("size_after_install");
		osSupported = messagesUser.getString("os_supported");
		defaultFolder = messagesUser.getString("default_folder");
		author = messagesUser.getString("author");
		localization = messagesUser.getString("localization");
		description = messagesUser.getString("description");
		developer = messagesUser.getString("developer");
		productCode = messagesUser.getString("product_code");
		productName = messagesUser.getString("product_name");
		technicalSupportTelephone = messagesUser.getString("technical_support_telephone");
		technicalSupportUrl = messagesUser.getString("technical_support_url");
		version = messagesUser.getString("version");
		visitJtmPlace = messagesUser.getString("visit_jtmplace");
		publicServerListNotFound = messagesUser.getString("public_server_list_not_found");
		connectedTo = messagesUser.getString("connected_to");
		programInstalled = messagesUser.getString("program_installed");
		doYouWantToRun = messagesUser.getString("do_you_want_to_run");
		accessing = messagesUser.getString("accessing");
		saveJtm = messagesUser.getString("save_jtm");
		saved = messagesUser.getString("saved");
		unzipping = messagesUser.getString("unzipping");
		downloading = messagesUser.getString("downloading");
		creatingFolders = messagesUser.getString("creating_folders");
		addingDesktopShortcuts = messagesUser.getString("adding_desktop_shortcuts");
		addingWindowsStartup = messagesUser.getString("adding_windows_startup");
		addingRegistryUninstaller = messagesUser.getString("adding_registry_uninstaller");
		addingRegistryAppPaths = messagesUser.getString("adding_registry_app_paths");
		associatingExtension = messagesUser.getString("associating_extension");
		thereAreOthersInstalls = messagesUser.getString("there_are_other_installs");
		thereIsNotInternetConnection = messagesUser.getString("there_is_not_internet_connection");
		installationCancelled = messagesUser.getString("installation_cancelled");
		settings = messagesUser.getString("settings");
		publicServers = messagesUser.getString("public_servers");
		cleaning = messagesUser.getString("cleaning");
		security = messagesUser.getString("security");
		showInformationCertificate = messagesUser.getString("show_information_certificate");
		keepUserSession = messagesUser.getString("keep_user_session");
		cleanTemporalFolder = messagesUser.getString("clean_temporal_folder");
		removeJtmAfterInstall = messagesUser.getString("remove_jtm_after_install");
		newVersionAvailable = messagesUser.getString("new_version_available");
		notifyNewVersion = messagesUser.getString("notify_new_version");
		errorDecompress = messagesUser.getString("error_decompress");
		errorDownload = messagesUser.getString("error_download");
		errorFindPath = messagesUser.getString("error_find_path");
		help = messagesUser.getString("help");
		helpContent = messagesUser.getString("help_content");
		about = messagesUser.getString("about");
		loggingStart = messagesUser.getString("logging_start");
		addShortcuts = messagesUser.getString("add_shortcuts");
		searchProgram = messagesUser.getString("search_program");
		versionCorrect = messagesUser.getString("version_correct");
		checkNewVersionWhenFailOpen = messagesUser.getString("check_new_version_fail_open");
		proxyConfiguration = messagesUser.getString("proxy_configuration");
		preferences = messagesUser.getString("preferences");
		network = messagesUser.getString("network");
		serverPublicList = messagesUser.getString("server_public_list");
	}
	
	/**
	 * Apurtu duuuuu!!
	 */
	
	public String getCancel(){
		return cancel;
	}

	public String getPreferences() {
		return preferences;
	}

	public String getNetwork() {
		return network;
	}

	public String getServerPublicList() {
		return serverPublicList;
	}

	public String getProxyConfiguration() {
		return proxyConfiguration;
	}

	public String getCheckNewVersionWhenFailOpen() {
		return checkNewVersionWhenFailOpen;
	}

	public String getVersionCorrect() {
		return versionCorrect;
	}

	public String getSearchProgram() {
		return searchProgram;
	}

	public String getAddShortcuts() {
		return addShortcuts;
	}

	public String getLoggingStart() {
		return loggingStart;
	}

	public String getHelp() {
		return help;
	}

	public String getHelpContent() {
		return helpContent;
	}

	public String getAbout() {
		return about;
	}

	public String getErrorDecompress() {
		return errorDecompress;
	}

	public String getErrorDownload() {
		return errorDownload;
	}

	public String getErrorFindPath() {
		return errorFindPath;
	}

	public String getNewVersionAvailable() {
		return newVersionAvailable;
	}

	public String getNotifyNewVersion() {
		return notifyNewVersion;
	}

	public String getVersionJtmInstaller() {
		return versionJtmInstaller;
	}

	public String getCleaning() {
		return cleaning;
	}

	public String getSecurity() {
		return security;
	}

	public String getShowInformationCertificate() {
		return showInformationCertificate;
	}

	public String getKeepUserSession() {
		return keepUserSession;
	}

	public String getCleanTemporalFolder() {
		return cleanTemporalFolder;
	}

	public String getRemoveJtmAfterInstall() {
		return removeJtmAfterInstall;
	}

	public String getPublicServers() {
		return publicServers;
	}

	public String getSettings() {
		return settings;
	}

	public String getInstallationCancelled() {
		return installationCancelled;
	}

	public String getThereIsNotInternetConnection() {
		return thereIsNotInternetConnection;
	}

	public String getThereAreOthersInstalls() {
		return thereAreOthersInstalls;
	}

	public String getAddingDesktopShortcuts() {
		return addingDesktopShortcuts;
	}

	public String getAddingWindowsStartup() {
		return addingWindowsStartup;
	}

	public String getAddingRegistryUninstaller() {
		return addingRegistryUninstaller;
	}

	public String getAddingRegistryAppPaths() {
		return addingRegistryAppPaths;
	}

	public String getAssociatingExtension() {
		return associatingExtension;
	}

	public String getCreatingFolders() {
		return creatingFolders;
	}

	public String getDownloading() {
		return downloading;
	}

	public String getUnzipping() {
		return unzipping;
	}

	public String getSaved() {
		return saved;
	}

	public String getSaveJtm() {
		return saveJtm;
	}

	public String getAccessing() {
		return accessing;
	}

	public String getDoYouWantToRun() {
		return doYouWantToRun;
	}

	public String getProgramInstalled() {
		return programInstalled;
	}

	public String getConnectedTo() {
		return connectedTo;
	}

	public String getPublicServerListNotFound() {
		return publicServerListNotFound;
	}

	public String getVisitJtmPlace() {
		return visitJtmPlace;
	}

	public String getTotalFiles() {
		return totalFiles;
	}

	public String getUrlDownloadFile() {
		return urlDownloadFile;
	}

	public String getSizeAfterInstall() {
		return sizeAfterInstall;
	}

	public String getOsSupported() {
		return osSupported;
	}

	public String getDefaultFolder() {
		return defaultFolder;
	}

	public String getAuthor() {
		return author;
	}

	public String getLocalization() {
		return localization;
	}

	public String getDescription() {
		return description;
	}

	public String getDeveloper() {
		return developer;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getTechnicalSupportTelephone() {
		return technicalSupportTelephone;
	}

	public String getTechnicalSupportUrl() {
		return technicalSupportUrl;
	}

	public String getVersion() {
		return version;
	}

	public String getNameOfTheProgram() {
		return nameOfTheProgram;
	}

	public String getInformationProgram() {
		return informationProgram;
	}

	public String getLoginError() {
		return loginError;
	}

	public String getInvalidServer() {
		return invalidServer;
	}

	public String getYouMustLoginFirst() {
		return youMustLoginFirst;
	}

	public String getRemove() {
		return remove;
	}

	public String getAccept() {
		return accept;
	}

	public String getPassword() {
		return password;
	}

	public String getEnterIP() {
		return enterIP;
	}

	public String getFile() {
		return file;
	}

	public String getUser() {
		return user;
	}

	public String getConfigurationMenu() {
		return configurationMenu;
	}

	public String getExit() {
		return exit;
	}

	public String getFavorites() {
		return favorites;
	}

	public String getServerConfiguration() {
		return serverConfiguration;
	}

	public String getAssociateExtension() {
		return associateExtension;
	}

	public String getInstallCurrentUser() {
		return installCurrentUser;
	}

	public String getInstallAllUsers() {
		return installAllUsers;
	}

	public String getSelectDirectory() {
		return selectDirectory;
	}

	public String getAddShortcutDesktop() {
		return addShortcutDesktop;
	}

	public String getAddShortcutStartMenu() {
		return addShortcutStartMenu;
	}

	public String getChange() {
		return change;
	}

	public String getInstallTo() {
		return installTo;
	}

	public String getConfiguration() {
		return configuration;
	}

	public String getWelcome() {
		return welcome;
	}

	public String getSearch() {
		return search;
	}

	public String getNext() {
		return next;
	}

	public String getPrevious() {
		return previous;
	}

	public String getErrorSpace() {
		return errorSpace;
	}

	public String getOsIncompatible() {
		return osIncompatible;
	}

	public String getErrorOpenFile() {
		return errorOpenFile;
	}

	public String getModified() {
		return modified;
	}

	public String getOpen() {
		return open;
	}

	public String getLogout() {
		return logout;
	}

	public String getLogin() {
		return login;
	}

	public String getInstall() {
		return install;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getScanAv() {
		return scanAv;
	}

	public String getOneClickInstall() {
		return oneClickInstall;
	}

	public String getNormalInstall() {
		return normalInstall;
	}

}
