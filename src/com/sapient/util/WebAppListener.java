package com.sapient.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.sapient.dao.BalloonDao;
import com.sapient.dao.BalloonDaoImpl;
import com.sapient.model.product.Balloon;

/**
 * Application Lifecycle Listener implementation class WebAppListener
 *
 */
public class WebAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WebAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	Logger log;
    	
    	ServletContext ctx = arg0.getServletContext();
    	
    	log = Logger.getLogger(WebAppListener.class.getName());

		BalloonDao balloonDao = new BalloonDaoImpl();

		List<Balloon> inventory;
		inventory = balloonDao.getInventory();
		ctx.setAttribute("inv", inventory);
    }
	
}
