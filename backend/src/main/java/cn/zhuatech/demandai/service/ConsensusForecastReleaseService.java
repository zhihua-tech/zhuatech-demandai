/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.demandai.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class ConsensusForecastReleaseService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.historyQualityPassed()) blockers.add("历史需求数据质量未通过");
        if (!request.promotionEventsReviewed()) blockers.add("促销与市场活动影响未复核");
        if (!request.productLaunchesReviewed()) blockers.add("新品与退市影响未复核");
        if (!request.outliersResolved()) blockers.add("异常需求点尚未处置");
        if (!request.modelAccuracyPassed()) blockers.add("预测模型准确率未达到阈值");
        if (!request.biasWithinTolerance()) blockers.add("预测偏差超出容忍范围");
        if (!request.commercialSignoff()) blockers.add("销售或市场未会签");
        if (!request.financeSignoff()) blockers.add("财务未会签");
        if (!request.supplySignoff()) blockers.add("供应计划未会签");
        if (!blockers.isEmpty()) {
            actions.add("阻断共识预测发布并重新完成跨部门评审");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.overridesExplained() || !request.scenarioBackupReady()) {
            if (!request.overridesExplained()) actions.add("补齐人工调整原因、责任人和影响量");
            if (!request.scenarioBackupReady()) actions.add("准备基准、乐观和保守情景");
            return new Assessment(Decision.CONSENSUS_REVIEW, blockers, actions);
        }
        actions.add("发布共识预测并锁定版本、会签和人工调整记录");
        return new Assessment(Decision.RELEASE, blockers, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String forecastVersion, boolean historyQualityPassed,
                          boolean promotionEventsReviewed, boolean productLaunchesReviewed,
                          boolean outliersResolved, boolean modelAccuracyPassed,
                          boolean biasWithinTolerance, boolean commercialSignoff,
                          boolean financeSignoff, boolean supplySignoff,
                          boolean overridesExplained, boolean scenarioBackupReady) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { RELEASE, CONSENSUS_REVIEW, BLOCKED }
}
