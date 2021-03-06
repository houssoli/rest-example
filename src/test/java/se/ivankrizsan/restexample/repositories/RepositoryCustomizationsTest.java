package se.ivankrizsan.restexample.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.ivankrizsan.restexample.domain.Circle;
import se.ivankrizsan.restexample.helpers.CircleEntityFactory;
import se.ivankrizsan.restexample.repositories.customisation.JpaRepositoryCustomisationsImpl;

/**
 * Tests the JPA repository customizations implemented in {@link JpaRepositoryCustomisationsImpl}.
 *
 * @author Ivan Krizsan
 */
@SpringBootTest
@EnableJpaRepositories(basePackages = {"se.ivankrizsan.restexample.repositories"},
    repositoryBaseClass = JpaRepositoryCustomisationsImpl.class)
public class RepositoryCustomizationsTest extends AbstractTestNGSpringContextTests {
    /* Constant(s): */
    public final static String UPDATED_COLOUR = "Black 2000";

    /* Instance variable(s): */
    @Autowired
    protected CircleRepository mRepository;
    protected CircleEntityFactory mEntityFactory;
    protected Circle mEntity;

    /**
     * Performs preparations before each test method.
     */
    @BeforeMethod
    public void prepareBeforeTest() {
        mEntityFactory = new CircleEntityFactory();

        final int theCreateEntityIndex = (int) Math.round(Math.random() * 100);
        mEntity = mEntityFactory.createEntity(theCreateEntityIndex);
    }

    /**
     * Tests persisting an entity that has not previously been persisted.
     * Expected outcome: The entity should be persisted and assigned an id.
     *
     * @throws Exception If error occurs. Indicates test failure.
     */
    @Test
    public void testPersistNewEntity() throws Exception {
        Circle theCircle = mRepository.persist(mEntity);
        Assert.assertNotNull(theCircle, "The entity should have been persisted");
        Assert.assertNotNull(theCircle.getId(), "The entity should have been assigned an id");
    }

    /**
     * Tests saving an entity that has not previously been persisted.
     * Expected outcome: The entity should be persisted and assigned an id.
     *
     * @throws Exception If error occurs. Indicates test failure.
     */
    @Test
    public void testUpdatePersistedEntity() throws Exception {
        final Circle theCircle = mRepository.persist(mEntity);
        Assert.assertNotNull(theCircle, "The entity should have been persisted");
        Assert.assertNotNull(theCircle.getId(), "The entity should have been assigned an id");

        final Circle theSameCircle = mRepository.findOne(theCircle.getId());
        theSameCircle.setColour(UPDATED_COLOUR);
        mRepository.persist(theSameCircle);
        final Circle theUpdatedCircle = mRepository.findOne(theCircle.getId());
        Assert.assertNotNull(theUpdatedCircle, "The updated entity should exist");
        Assert.assertEquals(theUpdatedCircle.getColour(), UPDATED_COLOUR,
            "The property in the entity should have been updated");
    }
}
