-- study.ebook definition

CREATE TABLE `ebook` (
                         `id` bigint(20) NOT NULL COMMENT 'id',
                         `name` varchar(255) DEFAULT NULL COMMENT '名称',
                         `category1id` bigint(20) NOT NULL COMMENT '分类1',
                         `category2id` bigint(20) NOT NULL COMMENT '分类2',
                         `description` varchar(200) DEFAULT NULL COMMENT '描述',
                         `cover` varchar(200) DEFAULT NULL COMMENT '封面',
                         `doc_count` int(11) NOT NULL COMMENT '文档数',
                         `view_count` int(11) NOT NULL COMMENT '阅读数',
                         `vote_count` int(11) NOT NULL COMMENT '点赞数',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;