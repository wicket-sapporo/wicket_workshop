package org.wicket_sapporo.springApp;

import org.apache.wicket.Session;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wicket_sapporo.springApp.page.SpringSignInPage;
import org.wicket_sapporo.springApp.page.SpringSignedPage;

/**
 * Application object for your web application. If you want to run this application without
 * deploying, run the Start class.
 */
public class SpringApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return SpringSignInPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		// IE6/7/8 は JQuery1, それ以外はJQuery2を利用
		getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());
		// MountedMapper
		mount(new MountedMapper("/spring_signin", SpringSignInPage.class));
		mount(new MountedMapper("/spring_signed", SpringSignedPage.class));
		// SpringのInjectorの初期化
		initSpring();
	}

	/**
	 * Spring用のInjectorを用意する.
	 */
	protected void initSpring() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Scan package for annotated beans
		ctx.scan("org.wicket_sapporo");
		ctx.refresh();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
	}

	@Override
	public Session newSession(Request request, Response response) {
		// 独自に拡張したSessionの利用
		return new SpringAppSession(request);
	}
}
