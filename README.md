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

```