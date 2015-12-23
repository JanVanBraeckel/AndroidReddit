package com.example.gebruiker.redditclient.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.gebruiker.redditclient.model.Batch;
import com.example.gebruiker.redditclient.model.Post;

import com.example.gebruiker.redditclient.model.BatchDao;
import com.example.gebruiker.redditclient.model.PostDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig batchDaoConfig;
    private final DaoConfig postDaoConfig;

    private final BatchDao batchDao;
    private final PostDao postDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        batchDaoConfig = daoConfigMap.get(BatchDao.class).clone();
        batchDaoConfig.initIdentityScope(type);

        postDaoConfig = daoConfigMap.get(PostDao.class).clone();
        postDaoConfig.initIdentityScope(type);

        batchDao = new BatchDao(batchDaoConfig, this);
        postDao = new PostDao(postDaoConfig, this);

        registerDao(Batch.class, batchDao);
        registerDao(Post.class, postDao);
    }
    
    public void clear() {
        batchDaoConfig.getIdentityScope().clear();
        postDaoConfig.getIdentityScope().clear();
    }

    public BatchDao getBatchDao() {
        return batchDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

}
