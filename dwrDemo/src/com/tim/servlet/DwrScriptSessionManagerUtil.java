package com.tim.servlet;

import javax.servlet.ServletException;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;


public class DwrScriptSessionManagerUtil extends DwrServlet
{

	private static final long serialVersionUID = -7504612622407420071L;

	public void init() throws ServletException
	{

		Container container = ServerContextFactory.get().getContainer();
		ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
		ScriptSessionListener listener = new ScriptSessionListener()
		{
			public void sessionCreated(ScriptSessionEvent ev)
			{
				String userId = "tianwei";
				System.out.println("a ScriptSession is created!");
				ev.getSession().setAttribute("userId", userId);
			}

			public void sessionDestroyed(ScriptSessionEvent ev)
			{
				System.out.println("a ScriptSession is distroyed");
			}
		};
		manager.addScriptSessionListener(listener);
	}
}
