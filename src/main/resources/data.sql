INSERT INTO `user` VALUES (1, NULL, '', '\0', '\0', 'aaa', NULL, NULL, 'aaa');
INSERT INTO `role` VALUES (1, '系统管理员', 'admin');
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `authority` VALUES (1, '市场信息', NULL, '市场信息', NULL, NULL, '/market', NULL);
INSERT INTO `authority` VALUES (2, '项目管理', NULL, '项目管理', NULL, NULL, '/project', NULL);
INSERT INTO `role_authority` VALUES (1, 1);
INSERT INTO `role_authority` VALUES (1, 2);
