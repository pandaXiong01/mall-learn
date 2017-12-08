package com.xiong.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by gonghui on 2017/12/7.
 */
public interface FileService {
    String upload(MultipartFile file, String path);
}
