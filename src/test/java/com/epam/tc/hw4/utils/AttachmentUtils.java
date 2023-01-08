package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "Attachment {attachmentName}")
    public byte[] attachImage(String attachmentName, byte[] source) {
        return source;
    }
}
