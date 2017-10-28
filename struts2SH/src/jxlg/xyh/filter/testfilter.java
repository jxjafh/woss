package jxlg.xyh.filter;

import jxlg.xyh.action.adaction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class testfilter extends AbstractInterceptor{
 @Override
public void init() {
	// TODO Auto-generated method stub
	super.init();
}
 @Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		Object a= arg0.getAction();
		if(a!=null)
		{
			if(a instanceof adaction)
			{
				adaction ada=(adaction) a;
				String content=ada.getName();
				if(content.contains("1")){
					content=content.replaceAll("1", "*");
					ada.setName(content);
				}
			}
		}
		return arg0.invoke();
	}

}
