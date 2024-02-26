package com.hoattt.demojwtauthentication.service;

import com.hoattt.demojwtauthentication.dto.request.CompanyCreateUpdateRequest;
import com.hoattt.demojwtauthentication.dto.response.CompanyCreateUpdateResponse;
import com.hoattt.demojwtauthentication.entity.Company;
import com.hoattt.demojwtauthentication.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_company() {
        //Given
//        CompanyCreateUpdateRequest request =
//                new CompanyCreateUpdateRequest(
//                        "Name",
//                        "companyunittrst@gmail.com",
//                        BigDecimal.valueOf(500.00)
//                );

//        Company company =
//                new Company(
//                        "Name",
//                        "companyunittrst@gmail.com",
//                        BigDecimal.valueOf(500.00)
//                );
        //Mock the calls

        //when

//        CompanyCreateUpdateResponse response = companyService.addCompany(request);

        //then
//        assertEquals(request.getName(), response.getName());
//        assertEquals(request.getEmail(), response.getEmail());
//        assertEquals(request.getCourseProfit(), response.getCourseProfit());
    }
}