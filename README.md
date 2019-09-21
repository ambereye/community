## 社区

## 资料
[Spring 文档](https://spring.io/guides)
[bootStrap 文档](https://v3.bootcss.com)
[es](https://elasticsearch.cn/)
[Githun Oauth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
    
    
## 工具
[Git](https://git-scm.com/download)
[VP画图模型的软件](Visual Paradigm 16.0)

## 脚本
```sql
create table user
(
    id           int auto_increment
        primary key,
    account_id   varchar(100) null,
    name         varchar(50)  null,
    token        char(36)     null,
    gmt_creat    bigint       null,
    gmt_modified bigint       null,
    bio          varchar(256) null
);
create table question
(
	id int auto_increment,
	title varchar(50) null,
	description TEXT null,
	gmt_create bigint null,
	gmt_modified bigint null,
	creator int null,
	comment_count int default 0 null,
	view_count int default 0 null,
	like_count int default 0 null,
	tag varchar(256) null,
	constraint question_pk
		primary key (id)
);
```

```bash
mvn -Dmybatis.generator.overwritre=true mybatis-generator:generate

```