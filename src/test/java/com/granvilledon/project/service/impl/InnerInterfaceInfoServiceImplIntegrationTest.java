package com.granvilledon.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.granvilledon.project.common.ErrorCode;
import com.granvilledon.project.exception.BusinessException;
import com.granvilledon.project.mapper.InterfaceInfoMapper;
import com.granvilledon.grapicommon.model.entity.InterfaceInfo;
import com.granvilledon.grapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InnerInterfaceInfoServiceImplIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InterfaceInfoMapper interfaceInfoMapper;

    @InjectMocks
    private InnerInterfaceInfoServiceImpl innerInterfaceInfoService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testPostRequest() throws Exception {
        // Arrange: Prepare mock data
        String url = "localhost:8123/api/name/user";
        String method = "POST";

        InterfaceInfo mockInterfaceInfo = new InterfaceInfo();
        mockInterfaceInfo.setId(1L);
        mockInterfaceInfo.setUrl(url);
        mockInterfaceInfo.setMethod(method);

        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);

        when(interfaceInfoMapper.selectOne(queryWrapper)).thenReturn(mockInterfaceInfo);

        // Act & Assert: Perform the POST request and verify the response
        mockMvc.perform(post("/api/name/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"granvilledon\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPostRequest_InvalidParams() throws Exception {
        // Arrange: Prepare invalid parameters
        String url = "";
        String method = "";

        // Act & Assert: Perform the POST request with invalid parameters and expect a 400 Bad Request
        mockMvc.perform(post("/api/name/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"granvilledon\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
