package com.granvilledon.project.service.impl;


import com.granvilledon.grapicommon.model.entity.InterfaceInfo;
import com.granvilledon.project.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceInfoServiceImplTest {

    private InterfaceInfoServiceImpl interfaceInfoService;

    @BeforeEach
    public void setUp() {
        interfaceInfoService = new InterfaceInfoServiceImpl();
    }

    @Test
    public void validInterfaceInfo_NullInterfaceInfo_ThrowsBusinessException() {
        assertThrows(BusinessException.class, () -> {
            interfaceInfoService.validInterfaceInfo(null, true);
        });
    }

    @Test
    public void validInterfaceInfo_AddTrueAndBlankName_ThrowsBusinessException() {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setName("");

        assertThrows(BusinessException.class, () -> {
            interfaceInfoService.validInterfaceInfo(interfaceInfo, true);
        });
    }

    @Test
    public void validInterfaceInfo_NameTooLong_ThrowsBusinessException() {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setName("ThisIsAVeryLongNameThatExceedsFiftyCharacters");

        assertThrows(BusinessException.class, () -> {
            interfaceInfoService.validInterfaceInfo(interfaceInfo, false);
        });
    }

    @Test
    public void validInterfaceInfo_ValidInput_NoException() {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setName("ValidName");

        assertDoesNotThrow(() -> {
            interfaceInfoService.validInterfaceInfo(interfaceInfo, true);
        });
    }
}