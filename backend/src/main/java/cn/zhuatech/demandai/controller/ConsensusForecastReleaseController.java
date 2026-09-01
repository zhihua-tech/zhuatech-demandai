/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.demandai.controller;

import cn.zhuatech.demandai.common.ApiResponse;
import cn.zhuatech.demandai.service.ConsensusForecastReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/demandai")
public class ConsensusForecastReleaseController {
    private final ConsensusForecastReleaseService service;
    public ConsensusForecastReleaseController(ConsensusForecastReleaseService service) { this.service = service; }
    @PostMapping("/consensus-forecast-release")
    public ApiResponse<ConsensusForecastReleaseService.Assessment> assess(
            @Valid @RequestBody ConsensusForecastReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
