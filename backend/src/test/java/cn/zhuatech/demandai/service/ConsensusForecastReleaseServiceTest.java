/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.demandai.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ConsensusForecastReleaseServiceTest {
    private final ConsensusForecastReleaseService service = new ConsensusForecastReleaseService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesSignedConsensusForecast() {
        var result = service.assess(new ConsensusForecastReleaseService.Request("D1", true, true, true,
                true, true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(ConsensusForecastReleaseService.Decision.RELEASE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsOverridesAndScenarios() {
        var result = service.assess(new ConsensusForecastReleaseService.Request("D2", true, true, true,
                true, true, true, true, true, true, false, false));
        assertThat(result.actions()).hasSize(2);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnqualifiedForecast() {
        var result = service.assess(new ConsensusForecastReleaseService.Request("D3", false, false, false,
                false, false, false, false, false, false, true, true));
        assertThat(result.blockers()).hasSize(9);
    }
}
