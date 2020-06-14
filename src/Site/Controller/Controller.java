/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site.Controller;

import Site.Models.SiteDAO;

/**
 *
 * @author Wind
 */
public class Controller {

    SiteDAO siteDAO = new SiteDAO();

    private Controller() {
    }

    public static Controller getInstance() {
        return ControllerHolder.INSTANCE;
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public String loginSite(String username, String password) {
        try {
            return siteDAO.SiteLogin(username, password);
        } catch (Exception e) {
            return "error";
        }
    }
}
