/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternationalOrderingSide.Controller;

import InternationalOrderingSide.Models.OrderedSiteDAO;
import InternationalOrderingSide.Models.OrderedSiteDTO;
import OfficeSide.Models.ItemDAO;
import OfficeSide.Models.ItemDTO;
import OfficeSide.Models.OrderDAO;
import Site.Models.SiteDAO;
import Site.Models.SiteItemDTO;
import java.util.List;

/**
 *
 * @author Wind
 */
public class Controller {

    private Controller() {
    }

    public static Controller getInstance() {
        return ControllerHolder.INSTANCE;
    }
    SiteDAO siteDAO = new SiteDAO();
    ItemDAO itemDAO = new ItemDAO();
    OrderDAO orderDAO = new OrderDAO();
    OrderedSiteDAO orderedSiteDAO = new OrderedSiteDAO();

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public List<SiteItemDTO> getSiteWithDeliverTypeAndItemIDSortASC(int itemId, String deliverType) {
        try {
            return siteDAO.getSiteWithDeliverTypeAndItemIDSortASC(itemId, deliverType);
        } catch (Exception e) {
            return null;
        }
    }

    public List<ItemDTO> loadItemsByOrderId(int orderId) {
        try {
            return itemDAO.loadAllItemsByOrderId(orderId);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addOrderedSite(OrderedSiteDTO orderedSiteDTO) {
        try {
            return orderedSiteDAO.addOrderedSite(orderedSiteDTO);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateOrderByOrderId(int orderID, int status) {
        try {
            return orderDAO.updateStatusOrderByOrderID(orderID, status);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateSiteAmountItem(int siteId, int itemId, int amount) {
        try {
            return siteDAO.updateSiteItem(siteId, itemId, amount);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteSiteItem(int siteId, int itemId) {
        try {
            return siteDAO.deleteSiteItem(siteId, itemId);
        } catch (Exception e) {
            return false;
        }
    }

}
