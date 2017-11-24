package com.tim.service;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;


public class HelloService
{

	public HelloService()
	{
		//		DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
		//
		//		try
		//		{
		//			dwrScriptSessionManagerUtil.init();
		//		}
		//		catch (ServletException e)
		//		{
		//
		//			e.printStackTrace();
		//
		//		}
	}

	public void push(String name)
	{

		Browser.withAllSessionsFiltered(new ScriptSessionFilter()
		{
			public boolean match(ScriptSession session)
			{
				return true;
			}
		}, new Runnable()
		{
			private ScriptBuffer script = new ScriptBuffer();

			public void run()
			{
				script.appendCall("callback", name);

				Collection<ScriptSession> sessions = Browser

						.getTargetSessions();

				for (ScriptSession scriptSession : sessions)
				{
					scriptSession.addScript(script);
				}
			}
		});



	}
}
