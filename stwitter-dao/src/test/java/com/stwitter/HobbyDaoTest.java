package com.stwitter;

import com.stwitter.dao.HobbyDao;
import com.stwitter.entity.Hobby;
import com.stwitter.factory.HobbyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * (c) Swissquote 7/30/16
 *
 * @author Shcherbina A.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class HobbyDaoTest {

    @Autowired
    private HobbyDao hobbyDao;

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveHobbyTest() {
        //GIVEN
        Hobby testHobby1 = HobbyFactory.getHobby();

        //WHEN
        hobbyDao.save(testHobby1);

        //THEN
        assertThat(hobbyDao.findAll(Hobby.class).size()).isEqualTo(1);
        Hobby savedHobby = hobbyDao.findAll(Hobby.class).get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(testHobby1.getDescription());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void findAllHobbiesTest() {
        //GIVEN
        Hobby testHobby1 = HobbyFactory.getHobby();
        Hobby testHobby2 = HobbyFactory.getHobby();

        //WHEN
        hobbyDao.save(testHobby1);
        hobbyDao.save(testHobby2);

        //THEN
        assertThat(hobbyDao.findAll(Hobby.class).size()).isEqualTo(2);
        Hobby savedHobby = hobbyDao.findAll(Hobby.class).get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(testHobby1.getDescription());
        Hobby savedHobby2 = hobbyDao.findAll(Hobby.class).get(1);
        assertThat(savedHobby2.getTitle()).isEqualTo(testHobby2.getTitle());
        assertThat(savedHobby2.getDescription()).isEqualTo(testHobby2.getDescription());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void uopdateHobbyTest() {
        //GIVEN
        String changedDescription = "Another Description";
        Hobby testHobby1 = HobbyFactory.getHobby();
        hobbyDao.save(testHobby1);

        //WHEN
        testHobby1.setDescription(changedDescription);
        hobbyDao.update(testHobby1);

        //THEN
        assertThat(hobbyDao.findAll(Hobby.class).size()).isEqualTo(1);
        Hobby savedHobby = hobbyDao.findAll(Hobby.class).get(0);
        assertThat(savedHobby.getTitle()).isEqualTo(testHobby1.getTitle());
        assertThat(savedHobby.getDescription()).isEqualTo(changedDescription);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteHobbyTest() {
        //GIVEN
        String changedDescription = "Another Description";
        Hobby testHobby1 = HobbyFactory.getHobby();
        hobbyDao.save(testHobby1);

        //WHEN
        hobbyDao.delete(testHobby1);

        //THEN
        assertTrue(hobbyDao.findAll(Hobby.class).isEmpty());
    }

}
