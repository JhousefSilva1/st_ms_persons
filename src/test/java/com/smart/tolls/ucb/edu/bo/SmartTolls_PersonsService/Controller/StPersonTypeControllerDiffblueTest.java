package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;

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

@ContextConfiguration(classes = {StPersonTypeController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StPersonTypeControllerDiffblueTest {
    @Autowired
    private StPersonTypeController stPersonTypeController;

    @MockBean
    private StPersonTypeService stPersonTypeService;

    /**
     * Test {@link StPersonTypeController#getAllPersonsType()}.
     * <p>
     * Method under test: {@link StPersonTypeController#getAllPersonsType()}
     */
    @Test
    @DisplayName("Test getAllPersonsType()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.getAllPersonsType()"})
    void testGetAllPersonsType() {
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
        (new StPersonTypeController()).getAllPersonsType();
    }

    /**
     * Test {@link StPersonTypeController#getAllPersonsTypeByStatus()}.
     * <p>
     * Method under test: {@link StPersonTypeController#getAllPersonsTypeByStatus()}
     */
    @Test
    @DisplayName("Test getAllPersonsTypeByStatus()")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.getAllPersonsTypeByStatus()"})
    void testGetAllPersonsTypeByStatus() {
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
        (new StPersonTypeController()).getAllPersonsTypeByStatus();
    }

    /**
     * Test {@link StPersonTypeController#getPersonTypeById(Long)}.
     * <p>
     * Method under test: {@link StPersonTypeController#getPersonTypeById(Long)}
     */
    @Test
    @DisplayName("Test getPersonTypeById(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.getPersonTypeById(Long)"})
    void testGetPersonTypeById() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<StPersonTypeEntity> actualPersonTypeById = (new StPersonTypeController()).getPersonTypeById(1L);

        // Assert
        assertEquals("", actualPersonTypeById.getError());
        assertEquals("Not Found", actualPersonTypeById.getMessage());
        assertNull(actualPersonTypeById.getData());
        assertEquals(404, actualPersonTypeById.getStatus().intValue());
    }

    /**
     * Test {@link StPersonTypeController#createPersonType(StPersonTypeEntity)}.
     * <p>
     * Method under test: {@link StPersonTypeController#createPersonType(StPersonTypeEntity)}
     */
    @Test
    @DisplayName("Test createPersonType(StPersonTypeEntity)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.createPersonType(StPersonTypeEntity)"})
    void testCreatePersonType() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StPersonTypeController stPersonTypeController = new StPersonTypeController();

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

        StPersonTypeEntity stPersonTypeEntity = new StPersonTypeEntity();
        stPersonTypeEntity.setAudit(audit);
        stPersonTypeEntity.setIdPersonType(1L);
        stPersonTypeEntity.setPersonType("Person Type");
        stPersonTypeEntity.setPersonTypeStatus(1);

        // Act
        ApiResponse<Optional<StPersonTypeEntity>> actualCreatePersonTypeResult = stPersonTypeController
                .createPersonType(stPersonTypeEntity);

        // Assert
        assertEquals("", actualCreatePersonTypeResult.getError());
        assertEquals("Bad Request", actualCreatePersonTypeResult.getMessage());
        assertNull(actualCreatePersonTypeResult.getData());
        assertEquals(400, actualCreatePersonTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StPersonTypeController#createPersonType(StPersonTypeEntity)}.
     * <p>
     * Method under test: {@link StPersonTypeController#createPersonType(StPersonTypeEntity)}
     */
    @Test
    @DisplayName("Test createPersonType(StPersonTypeEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.createPersonType(StPersonTypeEntity)"})
    void testCreatePersonType2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit["createDate"])
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

        StPersonTypeEntity stPersonTypeEntity = new StPersonTypeEntity();
        stPersonTypeEntity.setAudit(audit);
        stPersonTypeEntity.setIdPersonType(1L);
        stPersonTypeEntity.setPersonType("Person Type");
        stPersonTypeEntity.setPersonTypeStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stPersonTypeEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/personsType/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stPersonTypeController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StPersonTypeController#updatePersonType(Long, StPersonTypeEntity)}.
     * <p>
     * Method under test: {@link StPersonTypeController#updatePersonType(Long, StPersonTypeEntity)}
     */
    @Test
    @DisplayName("Test updatePersonType(Long, StPersonTypeEntity)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.updatePersonType(Long, StPersonTypeEntity)"})
    void testUpdatePersonType() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StPersonTypeController stPersonTypeController = new StPersonTypeController();

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

        StPersonTypeEntity stPersonTypeEntity = new StPersonTypeEntity();
        stPersonTypeEntity.setAudit(audit);
        stPersonTypeEntity.setIdPersonType(1L);
        stPersonTypeEntity.setPersonType("Person Type");
        stPersonTypeEntity.setPersonTypeStatus(1);

        // Act
        ApiResponse<Optional<StPersonTypeEntity>> actualUpdatePersonTypeResult = stPersonTypeController.updatePersonType(1L,
                stPersonTypeEntity);

        // Assert
        assertEquals("", actualUpdatePersonTypeResult.getError());
        assertEquals("Bad Request", actualUpdatePersonTypeResult.getMessage());
        assertNull(actualUpdatePersonTypeResult.getData());
        assertEquals(400, actualUpdatePersonTypeResult.getStatus().intValue());
    }

    /**
     * Test {@link StPersonTypeController#updatePersonType(Long, StPersonTypeEntity)}.
     * <p>
     * Method under test: {@link StPersonTypeController#updatePersonType(Long, StPersonTypeEntity)}
     */
    @Test
    @DisplayName("Test updatePersonType(Long, StPersonTypeEntity)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.updatePersonType(Long, StPersonTypeEntity)"})
    void testUpdatePersonType2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity["audit"]->com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit["createDate"])
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

        StPersonTypeEntity stPersonTypeEntity = new StPersonTypeEntity();
        stPersonTypeEntity.setAudit(audit);
        stPersonTypeEntity.setIdPersonType(1L);
        stPersonTypeEntity.setPersonType("Person Type");
        stPersonTypeEntity.setPersonTypeStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stPersonTypeEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/personsType/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(stPersonTypeController).build().perform(requestBuilder);
    }

    /**
     * Test {@link StPersonTypeController#deletePersonType(Long)}.
     * <p>
     * Method under test: {@link StPersonTypeController#deletePersonType(Long)}
     */
    @Test
    @DisplayName("Test deletePersonType(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonTypeController.deletePersonType(Long)"})
    void testDeletePersonType() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<Optional<StPersonTypeEntity>> actualDeletePersonTypeResult = (new StPersonTypeController())
                .deletePersonType(1L);

        // Assert
        assertEquals("", actualDeletePersonTypeResult.getError());
        assertEquals("Bad Request", actualDeletePersonTypeResult.getMessage());
        assertNull(actualDeletePersonTypeResult.getData());
        assertEquals(400, actualDeletePersonTypeResult.getStatus().intValue());
    }
}
