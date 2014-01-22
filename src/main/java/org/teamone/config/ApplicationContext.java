package org.teamone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;
import org.teamone.domain.Queue.QueueJDBCTemplate;
import org.teamone.domain.Role.RoleJDBCTemplate;
import org.teamone.domain.Role.RoleNameJDBCTemplate;
import org.teamone.domain.room.RoomJDBCTemplate;
import org.teamone.domain.User.UserJDBCTemplate;
import org.teamone.domain.Subject.SubjectJDBCTemplate;
import org.teamone.domain.userRights.UserRightsJDBCTemplate;
import org.teamone.domain.ApprovedTasks.ApprovedTasksJDBCTemplate;

@Configuration
@EnableWebMvc  // mvc annotation
@ComponentScan(basePackages = {"org.teamone"}) // pakken der controllerne ligger
public class ApplicationContext extends WebMvcConfigurationSupport {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        return new TilesConfigurer();
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(2);
        return tilesViewResolver;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        String url = "jdbc:mysql://mysql.stud.aitel.hist.no:3306/14-ing2-t1";
        String username = "14-ing2-t1";
        String password = "3EFmbAU";
        DriverManagerDataSource dmds = new DriverManagerDataSource(url, username, password);
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        return dmds;
    }

    @Bean
    public UserJDBCTemplate personJDBCTemplate() {
        UserJDBCTemplate personJDBCTemplate = new UserJDBCTemplate();
        personJDBCTemplate.setDataSource(dataSource());
        return personJDBCTemplate;
    }

    @Bean
    public SubjectJDBCTemplate subjectJDBCTemplate() {
        SubjectJDBCTemplate subjectJDBCTemplate = new SubjectJDBCTemplate();
        subjectJDBCTemplate.setDataSource(dataSource());
        return subjectJDBCTemplate;
    }

    @Bean
    public QueueJDBCTemplate queueJDBCTemplate() {
        QueueJDBCTemplate queueJDBCTemplate = new QueueJDBCTemplate();
        queueJDBCTemplate.setDataSource(dataSource());
        return queueJDBCTemplate;
    }

    @Bean
    public RoomJDBCTemplate roomJDBCTemplate() {
        RoomJDBCTemplate roomJDBCTemplate = new RoomJDBCTemplate();
        roomJDBCTemplate.setDataSource(dataSource());
        return roomJDBCTemplate;
    }

    @Bean
    public UserRightsJDBCTemplate userRightsJDBCTemplate() {
        UserRightsJDBCTemplate userRightsJDBCTemplate = new UserRightsJDBCTemplate();
        userRightsJDBCTemplate.setDataSource(dataSource());
        return userRightsJDBCTemplate;
    }

    @Bean
    public RoleJDBCTemplate roleJDBCTemplate() {
        RoleJDBCTemplate roleJDBCTemplate = new RoleJDBCTemplate();
        roleJDBCTemplate.setDataSource(dataSource());
        return roleJDBCTemplate;
    }

    @Bean
    public RoleNameJDBCTemplate roleNameJDBCTemplate() {
        RoleNameJDBCTemplate roleNameJDBCTemplate = new RoleNameJDBCTemplate();
        roleNameJDBCTemplate.setDataSource(dataSource());
        return roleNameJDBCTemplate;
    }

    @Bean
    public ApprovedTasksJDBCTemplate userTaskemplate() {
        ApprovedTasksJDBCTemplate userTaskJDBCTemplate = new ApprovedTasksJDBCTemplate();
        userTaskJDBCTemplate.setDataSource(dataSource());
        return userTaskJDBCTemplate;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/res/**").setCachePeriod(31556926);
    }

    @Override
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
        handlerMapping.setOrder(-1);
        return handlerMapping;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
