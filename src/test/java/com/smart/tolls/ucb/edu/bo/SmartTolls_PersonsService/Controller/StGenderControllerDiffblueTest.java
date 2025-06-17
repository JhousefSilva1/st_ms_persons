package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StGenderController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StGenderControllerDiffblueTest {
    @Autowired
    private StGenderController stGenderController;

    @MockBean
    private StGenderService stGenderService;

    /**
     * Test {@link StGenderController#getAllGenders()}.
     * <p>
     * Method under test: {@link StGenderController#getAllGenders()}
     */
    @Test
    @DisplayName("Test getAllGenders()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.getAllGenders()"})
    void testGetAllGenders() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: java.nio.charset.IllegalCharsetNameException:
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   java.nio.charset.IllegalCharsetNameException:
        //       at java.base/java.nio.charset.Charset.checkName(Charset.java:316)
        //       at java.base/java.nio.charset.Charset.lookup2(Charset.java:512)
        //       at java.base/java.nio.charset.Charset.lookup(Charset.java:492)
        //       at java.base/java.nio.charset.Charset.forName(Charset.java:556)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new StGenderController()).getAllGenders();
    }

    /**
     * Test {@link StGenderController#getAllGendersByStatus()}.
     * <p>
     * Method under test: {@link StGenderController#getAllGendersByStatus()}
     */
    @Test
    @DisplayName("Test getAllGendersByStatus()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.getAllGendersByStatus()"})
    void testGetAllGendersByStatus() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: java.nio.charset.IllegalCharsetNameException:
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   java.nio.charset.IllegalCharsetNameException:
        //       at java.base/java.nio.charset.Charset.checkName(Charset.java:316)
        //       at java.base/java.nio.charset.Charset.lookup2(Charset.java:512)
        //       at java.base/java.nio.charset.Charset.lookup(Charset.java:492)
        //       at java.base/java.nio.charset.Charset.forName(Charset.java:556)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new StGenderController()).getAllGendersByStatus();
    }

    /**
     * Test {@link StGenderController#getGenderById(Long)}.
     * <p>
     * Method under test: {@link StGenderController#getGenderById(Long)}
     */
    @Test
    @DisplayName("Test getGenderById(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.getGenderById(Long)"})
    void testGetGenderById() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<StGenderEntity> actualGenderById = (new StGenderController()).getGenderById(1L);

        // Assert
        assertEquals("", actualGenderById.getError());
        assertEquals("Not Found", actualGenderById.getMessage());
        assertNull(actualGenderById.getData());
        assertEquals(404, actualGenderById.getStatus().intValue());
    }

    /**
     * Test {@link StGenderController#createGender(StGenderEntity)}.
     * <p>
     * Method under test: {@link StGenderController#createGender(StGenderEntity)}
     */
    @Test
    @DisplayName("Test createGender(StGenderEntity)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.createGender(StGenderEntity)"})
    void testCreateGender() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StGenderController stGenderController = new StGenderController();

        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity stGenderEntity = new StGenderEntity();
        stGenderEntity.setAudit(audit);
        stGenderEntity.setGenderName("Gender Name");
        stGenderEntity.setGenderStatus(3);
        stGenderEntity.setIdGender(1L);

        // Act
        ApiResponse<Optional<StGenderEntity>> actualCreateGenderResult = stGenderController.createGender(stGenderEntity);

        // Assert
        assertEquals("", actualCreateGenderResult.getError());
        assertEquals("Bad Request", actualCreateGenderResult.getMessage());
        assertNull(actualCreateGenderResult.getData());
        assertEquals(400, actualCreateGenderResult.getStatus().intValue());
    }

    /**
     * Test {@link StGenderController#createGender(StGenderEntity)}.
     * <p>
     * Method under test: {@link StGenderController#createGender(StGenderEntity)}
     */
    @Test
    @DisplayName("Test createGender(StGenderEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.createGender(StGenderEntity)"})
    void testCreateGender2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1330)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:502)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:341)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4799)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:4040)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity stGenderEntity = new StGenderEntity();
        stGenderEntity.setAudit(audit);
        stGenderEntity.setGenderName("Gender Name");
        stGenderEntity.setGenderStatus(3);
        stGenderEntity.setIdGender(1L);
        String content = (new ObjectMapper()).writeValueAsString(stGenderEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/gender/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stGenderController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StGenderController#updateGender(Long, StGenderEntity)}.
     * <p>
     * Method under test: {@link StGenderController#updateGender(Long, StGenderEntity)}
     */
    @Test
    @DisplayName("Test updateGender(Long, StGenderEntity)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.updateGender(Long, StGenderEntity)"})
    void testUpdateGender() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StGenderController stGenderController = new StGenderController();

        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity stGenderEntity = new StGenderEntity();
        stGenderEntity.setAudit(audit);
        stGenderEntity.setGenderName("Gender Name");
        stGenderEntity.setGenderStatus(3);
        stGenderEntity.setIdGender(1L);

        // Act
        ApiResponse<Optional<StGenderEntity>> actualUpdateGenderResult = stGenderController.updateGender(1L,
                stGenderEntity);

        // Assert
        assertEquals("", actualUpdateGenderResult.getError());
        assertEquals("Bad Request", actualUpdateGenderResult.getMessage());
        assertNull(actualUpdateGenderResult.getData());
        assertEquals(400, actualUpdateGenderResult.getStatus().intValue());
    }

    /**
     * Test {@link StGenderController#updateGender(Long, StGenderEntity)}.
     * <p>
     * Method under test: {@link StGenderController#updateGender(Long, StGenderEntity)}
     */
    @Test
    @DisplayName("Test updateGender(Long, StGenderEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.updateGender(Long, StGenderEntity)"})
    void testUpdateGender2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit["createDate"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1330)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:183)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:502)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:341)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4799)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:4040)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity stGenderEntity = new StGenderEntity();
        stGenderEntity.setAudit(audit);
        stGenderEntity.setGenderName("Gender Name");
        stGenderEntity.setGenderStatus(3);
        stGenderEntity.setIdGender(1L);
        String content = (new ObjectMapper()).writeValueAsString(stGenderEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/gender/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stGenderController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StGenderController#deleteGender(Long)}.
     * <p>
     * Method under test: {@link StGenderController#deleteGender(Long)}
     */
    @Test
    @DisplayName("Test deleteGender(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StGenderController.deleteGender(Long)"})
    void testDeleteGender() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<Optional<StGenderEntity>> actualDeleteGenderResult = (new StGenderController()).deleteGender(1L);

        // Assert
        assertEquals("", actualDeleteGenderResult.getError());
        assertEquals("Bad Request", actualDeleteGenderResult.getMessage());
        assertNull(actualDeleteGenderResult.getData());
        assertEquals(400, actualDeleteGenderResult.getStatus().intValue());
    }
}
