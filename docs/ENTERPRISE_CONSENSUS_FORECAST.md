# 企业级共识预测发布治理

`POST /api/enterprise/demandai/consensus-forecast-release` 检查历史数据、促销、新品、异常值、模型准确率与偏差，以及销售、财务、供应会签和人工调整解释，返回 `RELEASE / CONSENSUS_REVIEW / BLOCKED`。

该流程可作为 S&OP 或 IBP 的预测版本门禁。生产环境应对接会议周期、需求层级、方案版本与实际偏差回写，形成可持续改进闭环。
