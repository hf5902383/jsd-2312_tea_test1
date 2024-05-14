package fanghou.email.admin.content.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knief4jConfig {

    private static final String BASIC_PACKAGE = "fanghou.email";
    private static final String GROUP_NAME = "FangTeam";
    private static final String DOCKET_VERSION = "1.0";
    private static final String CONTACT_EMAIL = "me@fanghou.email";
    private static final String DESCRIPTION = "TEA练习的描述简介";


    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        //指定使用Swagger2规范
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .description(DESCRIPTION)
                        .termsOfServiceUrl("https://doc.xiaominfo.com/")
                        .contact(CONTACT_EMAIL)
                        .version(DOCKET_VERSION)
                        .build())
                //分组名称
                .groupName(GROUP_NAME)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(BASIC_PACKAGE))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

}
