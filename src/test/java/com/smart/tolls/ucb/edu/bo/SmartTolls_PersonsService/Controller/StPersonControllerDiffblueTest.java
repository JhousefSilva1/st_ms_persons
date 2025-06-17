package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Client.CountryCityClient;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CityDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Dto.CountryDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StGenderEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity.StPersonTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Request.StPersonRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Models.Response.StPersonResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Service.StPersonTypeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StPersonController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StPersonControllerDiffblueTest {
    @MockBean
    private CountryCityClient countryCityClient;

    @MockBean
    private StGenderService stGenderService;

    @Autowired
    private StPersonController stPersonController;

    @MockBean
    private StPersonService stPersonService;

    @MockBean
    private StPersonTypeService stPersonTypeService;

    /**
     * Test {@link StPersonController#getAllPerons()}.
     * <ul>
     *   <li>Given {@link StPersonController} (default constructor).</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getAllPerons()}
     */
    @Test
    @DisplayName("Test getAllPerons(); given StPersonController (default constructor)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getAllPerons()"})
    void testGetAllPerons_givenStPersonController() {
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
        (new StPersonController()).getAllPerons();
    }

    /**
     * Test {@link StPersonController#getAllPersonsByStatus()}.
     * <ul>
     *   <li>Given {@link StPersonController} (default constructor).</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getAllPersonsByStatus()}
     */
    @Test
    @DisplayName("Test getAllPersonsByStatus(); given StPersonController (default constructor)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getAllPersonsByStatus()"})
    void testGetAllPersonsByStatus_givenStPersonController() {
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
        (new StPersonController()).getAllPersonsByStatus();
    }

    /**
     * Test {@link StPersonController#getPersonById(Long)}.
     * <ul>
     *   <li>Given {@link ApiResponse} (default constructor) Status is two hundred.</li>
     *   <li>Then content string a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getPersonById(Long)}
     */
    @Test
    @DisplayName("Test getPersonById(Long); given ApiResponse (default constructor) Status is two hundred; then content string a string")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getPersonById(Long)"})
    void testGetPersonById_givenApiResponseStatusIsTwoHundred_thenContentStringAString() throws Exception {
        // Arrange
        CityDto cityDto = new CityDto();
        cityDto.setCityName("Oxford");
        cityDto.setIdCity(1L);

        ApiResponse<CityDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(cityDto);
        apiResponse.setError("An error occurred");
        apiResponse.setMessage("Not all who wander are lost");
        apiResponse.setStatus(200);
        apiResponse.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        CountryDto countryDto = new CountryDto();
        countryDto.setCountryName("GB");
        countryDto.setIdCountry(1L);

        ApiResponse<CountryDto> apiResponse2 = new ApiResponse<>();
        apiResponse2.setData(countryDto);
        apiResponse2.setError("An error occurred");
        apiResponse2.setMessage("Not all who wander are lost");
        apiResponse2.setStatus(200);
        apiResponse2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(countryCityClient.getCountryById(Mockito.<Long>any())).thenReturn(apiResponse2);
        when(countryCityClient.getCityById(Mockito.<Long>any())).thenReturn(apiResponse);

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

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity gender = new StGenderEntity();
        gender.setAudit(audit2);
        gender.setGenderName("Gender Name");
        gender.setGenderStatus(3);
        gender.setIdGender(1L);

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StPersonTypeEntity personType = new StPersonTypeEntity();
        personType.setAudit(audit3);
        personType.setIdPersonType(1L);
        personType.setPersonType("Person Type");
        personType.setPersonTypeStatus(1);

        StPersonEntity stPersonEntity = new StPersonEntity();
        stPersonEntity.setAudit(audit);
        stPersonEntity.setGender(gender);
        stPersonEntity.setIdCity(1L);
        stPersonEntity.setIdCountry(1L);
        stPersonEntity.setIdPerson(1L);
        stPersonEntity.setPersonAddress("42 Main St");
        stPersonEntity.setPersonAge("Person Age");
        stPersonEntity.setPersonBirthdate("2020-03-01");
        stPersonEntity.setPersonDni("Person Dni");
        stPersonEntity.setPersonEmail("jane.doe@example.org");
        stPersonEntity.setPersonName("Person Name");
        stPersonEntity.setPersonPassword("iloveyou");
        stPersonEntity.setPersonStatus(1);
        stPersonEntity.setPersonSurname("Doe");
        stPersonEntity.setPersonType(personType);
        stPersonEntity.setPersonWhatsappNumber("42");
        Optional<StPersonEntity> ofResult = Optional.of(stPersonEntity);
        when(stPersonService.getPersonById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/persons/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPersonController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPerson\":1,\"personName\":\"Person Name\",\"personSurname\":\"Doe\","
                                        + "\"personWhatsappNumber\":\"42\",\"personPassword\":\"iloveyou\",\"personDni\":\"Person Dni\",\"personBirthdate\":"
                                        + "\"2020-03-01\",\"personEmail\":\"jane.doe@example.org\",\"personAddress\":\"42 Main St\",\"personAge\":\"Person"
                                        + " Age\",\"personStatus\":1,\"gender\":{\"idGender\":1,\"genderName\":\"Gender Name\",\"genderStatus\":3,\"audit\":{"
                                        + "\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0"
                                        + "],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\","
                                        + "\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"personType\":{\"idPersonType\":1,\"personType"
                                        + "\":\"Person Type\",\"personTypeStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"city\":{\"idCity\":1,\"cityName\":\"Oxford\"},\"country\":{\"idCountry\":1,\"countryName\":\"GB\"}},\"error\":"
                                        + "\"\"}"));
    }

    /**
     * Test {@link StPersonController#getPersonById(Long)}.
     * <ul>
     *   <li>Then content string {@code {"status":400,"message":"City not found","data":null,"error":""}}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getPersonById(Long)}
     */
    @Test
    @DisplayName("Test getPersonById(Long); then content string '{\"status\":400,\"message\":\"City not found\",\"data\":null,\"error\":\"\"}'")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getPersonById(Long)"})
    void testGetPersonById_thenContentStringStatus400MessageCityNotFoundDataNullError() throws Exception {
        // Arrange
        CityDto cityDto = new CityDto();
        cityDto.setCityName("Oxford");
        cityDto.setIdCity(1L);

        ApiResponse<CityDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(cityDto);
        apiResponse.setError("An error occurred");
        apiResponse.setMessage("Not all who wander are lost");
        apiResponse.setStatus(1);
        apiResponse.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(countryCityClient.getCityById(Mockito.<Long>any())).thenReturn(apiResponse);

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

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity gender = new StGenderEntity();
        gender.setAudit(audit2);
        gender.setGenderName("Gender Name");
        gender.setGenderStatus(3);
        gender.setIdGender(1L);

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StPersonTypeEntity personType = new StPersonTypeEntity();
        personType.setAudit(audit3);
        personType.setIdPersonType(1L);
        personType.setPersonType("Person Type");
        personType.setPersonTypeStatus(1);

        StPersonEntity stPersonEntity = new StPersonEntity();
        stPersonEntity.setAudit(audit);
        stPersonEntity.setGender(gender);
        stPersonEntity.setIdCity(1L);
        stPersonEntity.setIdCountry(1L);
        stPersonEntity.setIdPerson(1L);
        stPersonEntity.setPersonAddress("42 Main St");
        stPersonEntity.setPersonAge("Person Age");
        stPersonEntity.setPersonBirthdate("2020-03-01");
        stPersonEntity.setPersonDni("Person Dni");
        stPersonEntity.setPersonEmail("jane.doe@example.org");
        stPersonEntity.setPersonName("Person Name");
        stPersonEntity.setPersonPassword("iloveyou");
        stPersonEntity.setPersonStatus(1);
        stPersonEntity.setPersonSurname("Doe");
        stPersonEntity.setPersonType(personType);
        stPersonEntity.setPersonWhatsappNumber("42");
        Optional<StPersonEntity> ofResult = Optional.of(stPersonEntity);
        when(stPersonService.getPersonById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/persons/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPersonController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":400,\"message\":\"City not found\",\"data\":null,\"error\":\"\"}"));
    }

    /**
     * Test {@link StPersonController#getPersonById(Long)}.
     * <ul>
     *   <li>Then content string {@code {"status":400,"message":"Country not found","data":null,"error":""}}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getPersonById(Long)}
     */
    @Test
    @DisplayName("Test getPersonById(Long); then content string '{\"status\":400,\"message\":\"Country not found\",\"data\":null,\"error\":\"\"}'")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getPersonById(Long)"})
    void testGetPersonById_thenContentStringStatus400MessageCountryNotFoundDataNullError() throws Exception {
        // Arrange
        CityDto cityDto = new CityDto();
        cityDto.setCityName("Oxford");
        cityDto.setIdCity(1L);

        ApiResponse<CityDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(cityDto);
        apiResponse.setError("An error occurred");
        apiResponse.setMessage("Not all who wander are lost");
        apiResponse.setStatus(200);
        apiResponse.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        CountryDto countryDto = new CountryDto();
        countryDto.setCountryName("GB");
        countryDto.setIdCountry(1L);

        ApiResponse<CountryDto> apiResponse2 = new ApiResponse<>();
        apiResponse2.setData(countryDto);
        apiResponse2.setError("An error occurred");
        apiResponse2.setMessage("Not all who wander are lost");
        apiResponse2.setStatus(1);
        apiResponse2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(countryCityClient.getCountryById(Mockito.<Long>any())).thenReturn(apiResponse2);
        when(countryCityClient.getCityById(Mockito.<Long>any())).thenReturn(apiResponse);

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

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity gender = new StGenderEntity();
        gender.setAudit(audit2);
        gender.setGenderName("Gender Name");
        gender.setGenderStatus(3);
        gender.setIdGender(1L);

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StPersonTypeEntity personType = new StPersonTypeEntity();
        personType.setAudit(audit3);
        personType.setIdPersonType(1L);
        personType.setPersonType("Person Type");
        personType.setPersonTypeStatus(1);

        StPersonEntity stPersonEntity = new StPersonEntity();
        stPersonEntity.setAudit(audit);
        stPersonEntity.setGender(gender);
        stPersonEntity.setIdCity(1L);
        stPersonEntity.setIdCountry(1L);
        stPersonEntity.setIdPerson(1L);
        stPersonEntity.setPersonAddress("42 Main St");
        stPersonEntity.setPersonAge("Person Age");
        stPersonEntity.setPersonBirthdate("2020-03-01");
        stPersonEntity.setPersonDni("Person Dni");
        stPersonEntity.setPersonEmail("jane.doe@example.org");
        stPersonEntity.setPersonName("Person Name");
        stPersonEntity.setPersonPassword("iloveyou");
        stPersonEntity.setPersonStatus(1);
        stPersonEntity.setPersonSurname("Doe");
        stPersonEntity.setPersonType(personType);
        stPersonEntity.setPersonWhatsappNumber("42");
        Optional<StPersonEntity> ofResult = Optional.of(stPersonEntity);
        when(stPersonService.getPersonById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/persons/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPersonController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":400,\"message\":\"Country not found\",\"data\":null,\"error\":\"\"}"));
    }

    /**
     * Test {@link StPersonController#getPersonByPersonTypeId(Long)}.
     * <p>
     * Method under test: {@link StPersonController#getPersonByPersonTypeId(Long)}
     */
    @Test
    @DisplayName("Test getPersonByPersonTypeId(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getPersonByPersonTypeId(Long)"})
    void testGetPersonByPersonTypeId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StPersonController stPersonController = new StPersonController();
        stPersonController.stPersonService = new StPersonService();

        // Act
        ApiResponse<List<StPersonResponse>> actualPersonByPersonTypeId = stPersonController.getPersonByPersonTypeId(1L);

        // Assert
        assertEquals("", actualPersonByPersonTypeId.getError());
        assertEquals("Bad Request", actualPersonByPersonTypeId.getMessage());
        assertNull(actualPersonByPersonTypeId.getData());
        assertEquals(400, actualPersonByPersonTypeId.getStatus().intValue());
    }

    /**
     * Test {@link StPersonController#getPersonByPersonTypeId(Long)}.
     * <ul>
     *   <li>Given {@link StPersonController} (default constructor).</li>
     * </ul>
     * <p>
     * Method under test: {@link StPersonController#getPersonByPersonTypeId(Long)}
     */
    @Test
    @DisplayName("Test getPersonByPersonTypeId(Long); given StPersonController (default constructor)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.getPersonByPersonTypeId(Long)"})
    void testGetPersonByPersonTypeId_givenStPersonController() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPersonResponse>> actualPersonByPersonTypeId = (new StPersonController())
                .getPersonByPersonTypeId(1L);

        // Assert
        assertEquals("", actualPersonByPersonTypeId.getError());
        assertEquals("Bad Request", actualPersonByPersonTypeId.getMessage());
        assertNull(actualPersonByPersonTypeId.getData());
        assertEquals(400, actualPersonByPersonTypeId.getStatus().intValue());
    }

    /**
     * Test {@link StPersonController#createPerson(StPersonRequest)}.
     * <p>
     * Method under test: {@link StPersonController#createPerson(StPersonRequest)}
     */
    @Test
    @DisplayName("Test createPerson(StPersonRequest)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.createPerson(StPersonRequest)"})
    void testCreatePerson() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StPersonController stPersonController = new StPersonController();

        StPersonRequest stPersonRequest = new StPersonRequest();
        stPersonRequest.setIdCity(1L);
        stPersonRequest.setIdCountry(1L);
        stPersonRequest.setIdGender(1L);
        stPersonRequest.setIdPerson(1L);
        stPersonRequest.setIdPersonType(1L);
        stPersonRequest.setPersonAddress("42 Main St");
        stPersonRequest.setPersonAge("Person Age");
        stPersonRequest.setPersonBirthdate("2020-03-01");
        stPersonRequest.setPersonDni("Person Dni");
        stPersonRequest.setPersonEmail("jane.doe@example.org");
        stPersonRequest.setPersonName("Person Name");
        stPersonRequest.setPersonPassword("iloveyou");
        stPersonRequest.setPersonStatus(1);
        stPersonRequest.setPersonSurname("Doe");
        stPersonRequest.setPersonWhatsappNumber("42");

        // Act
        ApiResponse<Optional<StPersonEntity>> actualCreatePersonResult = stPersonController.createPerson(stPersonRequest);

        // Assert
        assertEquals("", actualCreatePersonResult.getError());
        assertEquals("Bad Request", actualCreatePersonResult.getMessage());
        assertNull(actualCreatePersonResult.getData());
        assertEquals(400, actualCreatePersonResult.getStatus().intValue());
    }

    /**
     * Test {@link StPersonController#updatePerson(Long, StPersonRequest)}.
     * <p>
     * Method under test: {@link StPersonController#updatePerson(Long, StPersonRequest)}
     */
    @Test
    @DisplayName("Test updatePerson(Long, StPersonRequest)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.updatePerson(Long, StPersonRequest)"})
    void testUpdatePerson() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        StPersonController stPersonController = new StPersonController();

        StPersonRequest stPersonRequest = new StPersonRequest();
        stPersonRequest.setIdCity(1L);
        stPersonRequest.setIdCountry(1L);
        stPersonRequest.setIdGender(1L);
        stPersonRequest.setIdPerson(1L);
        stPersonRequest.setIdPersonType(1L);
        stPersonRequest.setPersonAddress("42 Main St");
        stPersonRequest.setPersonAge("Person Age");
        stPersonRequest.setPersonBirthdate("2020-03-01");
        stPersonRequest.setPersonDni("Person Dni");
        stPersonRequest.setPersonEmail("jane.doe@example.org");
        stPersonRequest.setPersonName("Person Name");
        stPersonRequest.setPersonPassword("iloveyou");
        stPersonRequest.setPersonStatus(1);
        stPersonRequest.setPersonSurname("Doe");
        stPersonRequest.setPersonWhatsappNumber("42");

        // Act
        ApiResponse<Optional<StPersonEntity>> actualUpdatePersonResult = stPersonController.updatePerson(1L,
                stPersonRequest);

        // Assert
        assertEquals("", actualUpdatePersonResult.getError());
        assertEquals("Error updating person", actualUpdatePersonResult.getMessage());
        assertNull(actualUpdatePersonResult.getData());
        assertEquals(400, actualUpdatePersonResult.getStatus().intValue());
    }

    /**
     * Test {@link StPersonController#deletePerson(Long)}.
     * <p>
     * Method under test: {@link StPersonController#deletePerson(Long)}
     */
    @Test
    @DisplayName("Test deletePerson(Long)")
    @Tag("MaintainedByDiffblue")
    @MethodsUnderTest({"ApiResponse StPersonController.deletePerson(Long)"})
    void testDeletePerson() throws Exception {
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

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StGenderEntity gender = new StGenderEntity();
        gender.setAudit(audit2);
        gender.setGenderName("Gender Name");
        gender.setGenderStatus(3);
        gender.setIdGender(1L);

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StPersonTypeEntity personType = new StPersonTypeEntity();
        personType.setAudit(audit3);
        personType.setIdPersonType(1L);
        personType.setPersonType("Person Type");
        personType.setPersonTypeStatus(1);

        StPersonEntity stPersonEntity = new StPersonEntity();
        stPersonEntity.setAudit(audit);
        stPersonEntity.setGender(gender);
        stPersonEntity.setIdCity(1L);
        stPersonEntity.setIdCountry(1L);
        stPersonEntity.setIdPerson(1L);
        stPersonEntity.setPersonAddress("42 Main St");
        stPersonEntity.setPersonAge("Person Age");
        stPersonEntity.setPersonBirthdate("2020-03-01");
        stPersonEntity.setPersonDni("Person Dni");
        stPersonEntity.setPersonEmail("jane.doe@example.org");
        stPersonEntity.setPersonName("Person Name");
        stPersonEntity.setPersonPassword("iloveyou");
        stPersonEntity.setPersonStatus(1);
        stPersonEntity.setPersonSurname("Doe");
        stPersonEntity.setPersonType(personType);
        stPersonEntity.setPersonWhatsappNumber("42");
        Optional<StPersonEntity> ofResult = Optional.of(stPersonEntity);
        when(stPersonService.deletePerson(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/persons/delete/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPersonController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPerson\":1,\"personName\":\"Person Name\",\"personSurname\":\"Doe\","
                                        + "\"personBirthdate\":\"2020-03-01\",\"personWhatsappNumber\":\"42\",\"personEmail\":\"jane.doe@example.org\","
                                        + "\"personPassword\":\"iloveyou\",\"personDni\":\"Person Dni\",\"personAddress\":\"42 Main St\",\"personAge\":\"Person"
                                        + " Age\",\"idCountry\":1,\"idCity\":1,\"gender\":{\"idGender\":1,\"genderName\":\"Gender Name\",\"genderStatus\":3,"
                                        + "\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":"
                                        + "[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\""
                                        + ":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"personType\":{\"idPersonType\""
                                        + ":1,\"personType\":\"Person Type\",\"personTypeStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970"
                                        + ",1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":"
                                        + "[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\","
                                        + "\"recordVersion\":1}},\"personStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0"
                                        + ",0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"error\":\"\"}"));
    }
}
