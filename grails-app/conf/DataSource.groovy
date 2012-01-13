dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "AeonATK"
    password = "AeonATK"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = 'update'
            url = "jdbc:mysql://localhost:3306/yale"
        }
    }
    test {
        dataSource {
            dbCreate = 'update'
            url = "jdbc:mysql://localhost:3306/yale"
        }
    }
    
    production {
        dataSource {
            dbCreate = 'update'
            url = "jdbc:mysql://localhost:3306/yale"
        }
    }
}