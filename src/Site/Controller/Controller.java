/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site.Controller;

import OfficeSide.Models.ItemDTO;
import Site.Models.SiteDAO;
import Site.Models.SiteDTO;
import Site.Models.SiteItemDTO;
import java.util.List;

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

    public List<ItemDTO> getSiteItem(int siteId) {
        try {
            return siteDAO.getSiteItem(siteId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean updateSiteItem(int siteID, int itemID, int amount) {
        try {
            return siteDAO.updateSiteItem(siteID, itemID, amount);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean createSiteItem(int siteID, int itemID, int amount) {
        try {
            return siteDAO.createNewSiteItem(siteID, itemID, amount);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteSiteItem(int siteID, int itemID) {
        try {
            return siteDAO.deleteSiteItem(siteID, itemID);
        } catch (Exception e) {
            return false;
        }
    }

    public int getSiteID(String siteName) {
        try {
            return siteDAO.getIDSite(siteName);
        } catch (Exception e) {
            return -2;
        }
    }

    public SiteDTO getSiteInfo(int siteId) {
        try {
            return siteDAO.getSiteInfo(siteId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean updateSiteDeliveryDay(int siteId, int days) {
        try {
            return siteDAO.updateDeliveryTimeSite(siteId, days);
        } catch (Exception e) {
            return false;
        }
    }

}
