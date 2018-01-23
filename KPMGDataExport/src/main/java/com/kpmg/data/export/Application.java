package com.kpmg.data.export;

import com.kpmg.data.export.assemble.AssembleCompoment;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		AssembleCompoment assembleCompoment = new AssembleCompoment();
		assembleCompoment.assemble();
	}
}
