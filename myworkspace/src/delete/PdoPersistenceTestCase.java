package com.ford.pdo.domain.testcase;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ford.it.context.RequestContext;
import com.ford.it.entity.bo.BaseBO;
import com.ford.it.entity.ro.BaseRO;
import com.ford.it.persistencecore.testcase.PcIncontainerTestCase;
import com.ford.pdo.domain.AssembledMarketViewBO;
import com.ford.pdo.domain.AssembledMarketViewRO;
import com.ford.pdo.domain.AuthorizationLetterBO;
import com.ford.pdo.domain.AuthorizationLetterRO;
import com.ford.pdo.domain.BaseMenuOfferBO;
import com.ford.pdo.domain.BaseMenuOfferRO;
import com.ford.pdo.domain.FamilyBO;
import com.ford.pdo.domain.FeatureBO;
import com.ford.pdo.domain.GlobalMenuOfferBO;
import com.ford.pdo.domain.GlobalMenuOfferRO;
import com.ford.pdo.domain.MarketMenuOfferBO;
import com.ford.pdo.domain.MarketMenuOfferRO;
import com.ford.pdo.domain.RuleBO;
import com.ford.pdo.domain.RuleRO;
import com.ford.pdo.domain.TimingPointBO;
import com.ford.pdo.domain.VehicleBO;
import com.ford.pdo.domain.VehicleRO;
import com.ford.pdo.domain.lookup.OptionalityBO;
import com.ford.pdo.domain.lookup.StatusBO;
import com.ford.pdo.domain.lookup.StatusRO;
import com.ford.pdo.domain.masterdictionary.GlobalFamilyBO;
import com.ford.pdo.domain.masterdictionary.GlobalFamilyRO;
import com.ford.pdo.domain.masterdictionary.GlobalFeatureBO;
import com.ford.pdo.domain.masterdictionary.GlobalFeatureRO;
import com.ford.pdo.domain.masterdictionary.query.GlobalFeatureNamedQueryConfig;
import com.ford.pdo.domain.query.VehicleNamedQueryConfig;

/**
 * This is a base class for unit testing.
 * 
 * @since 2.0
 */
public abstract class PdoPersistenceTestCase extends PcIncontainerTestCase {

    /**
     * PDO Application Service instance for testing the TopLink mappings and
     * queries in the Domain layer
     */
    protected static final PdoDomainTestingAS PDO_DOMAIN_TEST_AS =
            new PdoDomainTestingAS("PDOPersistenceConfig");

    /**
     * Logging Setup
     */
    private static final String CLASS_NAME =
            PdoPersistenceTestCase.class.getName();

    /**
     * Logging Setup
     */
    private static final com.ford.it.logging.ILogger log =
            com.ford.it.logging.LogFactory.getInstance().getLogger(CLASS_NAME);

    private static final Calendar CALENDAR_TIME = Calendar.getInstance();

    private String userid =
            RequestContext.getLocalInstance().getUserId("JUNIT");

    /**
     * Constructs a test case with the given name.
     * 
     * @param testName
     */
    public PdoPersistenceTestCase(final String testName) {
        super(testName);
    }

    /**
     * This convenience method can be invoked from a finally block in a test
     * method to delete test Business Objects.
     * 
     * @param baseBOs Business objects for deletion.
     */
    protected void deleteBOs(final BaseBO... baseBOs) {

        super.deleteBOs(PDO_DOMAIN_TEST_AS, baseBOs);

    }

    /**
     ************************************************************************** 
     * get the AssembledMarketView object based on the object key
     * 
     * @param menuKey : object key
     * @return AssembledMarketViewRO : the menu offer object
     */
    public static AssembledMarketViewRO retrieveAssembledMarketView(
            final long menuKey) {

        final AssembledMarketViewRO assembledMarketView =
                PDO_DOMAIN_TEST_AS.findByPk(new AssembledMarketViewBO(menuKey));

        return assembledMarketView;

    }

    /**
     ************************************************************************** 
     * get the menu offer object based on the object key
     * 
     * @param menuKey : object key
     * @return baseMenuOfferRO : the menu offer object
     */
    public static BaseMenuOfferRO retrieveMenuOffer(final long menuKey) {

        final BaseMenuOfferRO baseMenuOfferRO =
                PDO_DOMAIN_TEST_AS.findByPk(new BaseMenuOfferBO(menuKey));

        return baseMenuOfferRO;
    }

    /**
     ************************************************************************** 
     * get the global menu offer object based on the object key
     * 
     * @param menuKey : object key
     * @return globalMenuOfferRO : the global menu offer object
     */
    public static GlobalMenuOfferRO retrieveGlobalMenuOffer(final long menuKey) {

        final GlobalMenuOfferRO globalMenuOfferRO =
                PDO_DOMAIN_TEST_AS.findByPk(new GlobalMenuOfferBO(menuKey));

        return globalMenuOfferRO;
    }

    /**************************************************************************
     * get the market menu offer object based on the object key
     * 
     * @param menuKey : object key
     * @return baseMenuOfferRO : the menu offer object
     */
    public static MarketMenuOfferRO retrieveMarketMenuOffer(final long menuKey) {

        final MarketMenuOfferRO marketMenuOfferRO =
                PDO_DOMAIN_TEST_AS.findByPk(new MarketMenuOfferBO(menuKey));

        return marketMenuOfferRO;
    }

    /**
     ************************************************************************** 
     * get the GlobalFamily object based on the object key
     * 
     * @param globalFamilyKey
     * @return baseMenuOfferRO : the menu offer object
     */
    public static GlobalFamilyRO retrieveGlobalFamily(final long globalFamilyKey) {

        final GlobalFamilyRO globalFamilyRO =
                PDO_DOMAIN_TEST_AS.findByPk(new GlobalFamilyBO(globalFamilyKey));

        return globalFamilyRO;
    }

    /**
     ************************************************************************** 
     * get the Status object based on the object key
     * 
     * @param statusId
     * @return baseMenuOfferRO : the menu offer object
     */
    public static StatusRO retrieveStatus(final Integer statusId) {

        final StatusRO statusRO =
                PDO_DOMAIN_TEST_AS.findByPk(new StatusBO(statusId));

        return statusRO;
    }

    /**
     ************************************************************************** 
     * get the AuthorizationLetter object based on the Auth key
     * 
     * @param authKey
     * @return AuthorizationLetterRO
     */
    public static AuthorizationLetterRO retrieveAuthorizationLetter(
            final long authKey) {

        final AuthorizationLetterRO authorizationLetterRO =
                PDO_DOMAIN_TEST_AS.findByPk(new AuthorizationLetterBO(authKey));

        return authorizationLetterRO;
    }

    /**
     ************************************************************************** 
     * get the GlobalFeature object based on the object key
     * 
     * @param globalFeatureKey
     * @return baseMenuOfferRO : the menu offer object
     */
    public static GlobalFeatureRO retrieveGlobalFeature(
            final long globalFeatureKey) {

        final GlobalFeatureRO globalFeatureRO =
                PDO_DOMAIN_TEST_AS.findByPk(new GlobalFeatureBO(
                        globalFeatureKey));

        return globalFeatureRO;
    }

    /**
     * Compares two GlobalFamily object. The attributes of the objects that
     * needs to be compared are expected to have overridden the "equal" method,
     * if specific business logic needs to apply to test for equality
     * 
     * @param <BO> : generic BO
     * @param <RO> : generic RO
     * 
     * @param firstBean : First bean object
     * @param secondBean : second bean object
     * 
     * @param compareAttrib : attributes of the beans that should be compared.
     * @param clazz
     * 
     * @return String : result of execution of test. "" is expected if no delta
     *         is found. Any error is eaten up by this method and is logged as
     *         the returned value.
     */
    protected static <RO extends BaseRO, BO extends BaseBO> String fullPersistedBeanValidity(
            final BO firstBean, final RO secondBean,
            final List<String> compareAttrib, final Class<?> clazz) {

        final String METHOD_NAME = "fullPersistedBeanValidity";

        log.entering(CLASS_NAME, METHOD_NAME);
        StringBuilder builder = new StringBuilder();
        final StringBuilder error = new StringBuilder();

        BeanInfo boInfo;
        try {
            boInfo = Introspector.getBeanInfo(clazz);

            final PropertyDescriptor[] boPropDescriptors =
                    boInfo.getPropertyDescriptors();

            for (int index = 0; index < boPropDescriptors.length; index++) {

                final PropertyDescriptor descriptor = boPropDescriptors[index];
                final String attrib = descriptor.getName();
                if (compareAttrib.contains(attrib)) {
                    final Method readMethod = descriptor.getReadMethod();
                    final Object objectOne = readMethod.invoke(firstBean);
                    final Object objectTwo = readMethod.invoke(secondBean);
                    builder.append(compareValues(objectOne, objectTwo, attrib));
                }
            }
        } catch (final Exception e) {

            error.append("Exception occured in");
            error.append("\n Class:" + CLASS_NAME);
            error.append("\n Method: " + METHOD_NAME);
            error.append("\n Excpetion" + e.getMessage());
            error.append("\n\n");
            builder = error;
        }
        log.exiting(CLASS_NAME, METHOD_NAME);
        return error.toString() + builder.toString();
    }

    /**
     * compare two values and returns a "" or a string if the compare fails
     * 
     * @param bo : the first object to be compared
     * @param ro : the first object to be compared
     * @param attrib : the name of the attribute that is being compared
     * 
     * @return String
     */
    private static String compareValues(final Object bo, final Object ro,
            final String attrib) {

        if ((ro == null) && bo == null) {
            return "";

        } else if (ro == null || bo == null) {
            return "Expected " + attrib + ": " + bo + " " + " but got "
                   + attrib + ": " + ro + "\n";
        } else if (!bo.equals(ro)) {
            return "Expected " + attrib + ": " + bo + " " + " but got "
                   + attrib + ": " + ro + "\n";
        } else {
            return "";
        }
    }

    /**
     * Gives the clone of MenuOffer based on menuKey
     * 
     * @param newMenuOffer
     * @param menuKey
     * @return BaseMenuOfferBO
     */
    protected BaseMenuOfferBO createMenuOffer(
            final BaseMenuOfferBO newMenuOffer, final long menuKey) {

        List<RuleBO> ruleList = new ArrayList<RuleBO>();

        final BaseMenuOfferRO copyMenuOfferRO =
                retrieveGlobalMenuOffer(menuKey);

        final BaseMenuOfferBO copyMenuOfferBO =
                PDO_DOMAIN_TEST_AS.preBindAssociateLookup(copyMenuOfferRO);

        newMenuOffer.setAuthorizationLetter(copyMenuOfferBO.getAuthorizationLetter());
        newMenuOffer.setCreateTime(CALENDAR_TIME);
        newMenuOffer.setCreateUser(this.userid);
        final List<FamilyBO> familyList =
                createFamilyList(copyMenuOfferBO, newMenuOffer, 4);
        newMenuOffer.setFamilyList(familyList);
        newMenuOffer.setLastUpdateTime(CALENDAR_TIME);
        newMenuOffer.setLastUpdateUser(this.userid);
        newMenuOffer.setName(copyMenuOfferBO.getName());
        newMenuOffer.setOwnerJobCode(copyMenuOfferBO.getOwnerJobCode());
        ruleList = createRuleList(copyMenuOfferBO, newMenuOffer);
        newMenuOffer.setRuleList(ruleList);
        final StatusRO statusRO = retrieveStatus(new Integer(1));
        final StatusBO statusBO =
                PDO_DOMAIN_TEST_AS.preBindAssociateLookup(statusRO);
        newMenuOffer.setStatus(statusBO);
        final List<TimingPointBO> timingPointList =
                createTimingPointList(copyMenuOfferBO, newMenuOffer);
        newMenuOffer.setTimingPointList(timingPointList);
        final VehicleBO vehicleBO = retrieveVehicle();
        newMenuOffer.setVehicle(vehicleBO);
        newMenuOffer.setVersionId(1);

        return newMenuOffer;

    }

    /**
     * Get the Rule List
     */
    private List<RuleBO> createRuleList(final BaseMenuOfferBO copyMenuOfferBO,
            final BaseMenuOfferBO newMenuOffer) {
        List<RuleRO> ruleRoList = copyMenuOfferBO.getRuleList();

        final Calendar calendar = Calendar.getInstance();
        final List<RuleBO> ruleList = new ArrayList<RuleBO>();
        final FeatureBO featureBO =
                newMenuOffer.getFeatureListForUpdateOnly().get(0);

        final List<TimingPointBO> timingPointList =
                createTimingPointList(copyMenuOfferBO, newMenuOffer);

        final TimingPointBO inTimingPointBO = timingPointList.get(0);
        final TimingPointBO outTimingPointBO = timingPointList.get(1);

        if (ruleRoList.size() > 3)
            ruleRoList = ruleRoList.subList(0, 3);

        for (final RuleRO ruleRO : ruleRoList) {
            final RuleBO ruleBO = new RuleBO();
            final AuthorizationLetterBO authorizationLetterBO =
                    copyMenuOfferBO.getAuthorizationLetter();
            // PDO_DOMAIN_TEST_AS.preBindAssociateLookup(ruleRO.getAuthorizationLetter());
            ruleBO.setAuthorizationLetter(authorizationLetterBO);
            ruleBO.setCreateTime(calendar);
            ruleBO.setCreateUser(this.userid);
            ruleBO.setFeature(featureBO);
            // final TimingPointBO inTimingPointBO = copyMenuOfferBO.gett
            // PDO_DOMAIN_TEST_AS.preBindAssociateLookup(ruleRO.getInTimingPoint());
            ruleBO.setInTimingPoint(inTimingPointBO);
            ruleBO.setIsChangedFlag(false);
            ruleBO.setIsNegativeFlag(false);
            ruleBO.setIsSummaryFlag(false);
            ruleBO.setLastUpdateTime(calendar);
            ruleBO.setLastUpdateUser(this.userid);
            ruleBO.setMenuOffer(newMenuOffer);
            final OptionalityBO optionalityBO =
                    PDO_DOMAIN_TEST_AS.preBindAssociateLookup(ruleRO.getOptionality());
            ruleBO.setOptionality(optionalityBO);
            /*final TimingPointBO outTimingPointBO =
                    PDO_DOMAIN_TEST_AS.preBindAssociateLookup(ruleRO.getOutTimingPoint());*/
            ruleBO.setOutTimingPoint(outTimingPointBO);
            ruleBO.setPackageFeature(null);

            ruleList.add(ruleBO);
        }
        // setting the ruleList to Feature
        featureBO.setRuleList(ruleList);

        return ruleList;
    }

    /**
     * Get the Status
     */
    /*
        private StatusBO retrieveStatus() {

            final StatusRO statusRO = retrieveStatus(new Integer(4));
            final StatusBO statusBO =
                    PDO_DOMAIN_TEST_AS.preBindAssociateLookup(statusRO);

            return statusBO;
        }*/

    /**
     * Get the Family List by copying families from menuKey
     */
    private List<FamilyBO> createFamilyList(
            final BaseMenuOfferBO copyMenuOfferBO,
            final BaseMenuOfferBO newMenuOffer, final int maxSize) {
        final List<FamilyBO> familyList = new ArrayList<FamilyBO>();
        List<FamilyBO> familyBOList =
                copyMenuOfferBO.getFamilyListForUpdateOnly();

        if (familyBOList.size() > maxSize)
            familyBOList = familyBOList.subList(0, maxSize);

        for (final FamilyBO copyFamilyBO : familyBOList) {
            final FamilyBO newFamilyBO = new FamilyBO();

            final List<FeatureBO> featureList = new ArrayList<FeatureBO>();
            final FeatureBO copyFeatureBO =
                    copyFamilyBO.getFeatureListForUpdateOnly().get(0);
            final FeatureBO newFeatureBO =
                    createFeatureBO(copyFeatureBO.getCode(), newFamilyBO);
            featureList.add(newFeatureBO);

            newFamilyBO.setCreateTime(CALENDAR_TIME);
            newFamilyBO.setCreateUser(this.userid);
            newFamilyBO.setFeatureList(featureList);
            newFamilyBO.setGlobalFamily(copyFamilyBO.getGlobalFamily());
            newFamilyBO.setHierarchyLevel(1);
            newFamilyBO.setHierarchyGroup(16);
            newFamilyBO.setIsExcludeFromCompletenessFlag(false);
            newFamilyBO.setIsExcludeFromReleaseFlag(false);
            newFamilyBO.setIsViewQualifierFlag(false);
            newFamilyBO.setLastUpdateTime(CALENDAR_TIME);
            newFamilyBO.setLastUpdateUser(this.userid);
            newFamilyBO.setMenuOffer(newMenuOffer);
            newFamilyBO.setPositionInSuperFamily(1);
            newFamilyBO.setStandardRequiredOverrideFlag(false);
            newFamilyBO.setVehicleConsistencyCheckRequiredFlag(false);

            familyList.add(newFamilyBO);
        }
        return familyList;
    }

    /**
     * Get the TimingPoint List
     */
    private List<TimingPointBO> createTimingPointList(
            final BaseMenuOfferBO copyMenuOfferBO,
            final BaseMenuOfferBO menuOffer) {
        final List<TimingPointBO> timingPointBOList =
                new ArrayList<TimingPointBO>();

        List<TimingPointBO> copyTimingPointBOList =
                copyMenuOfferBO.getTimingPointListForUpdateOnly();

        if (copyTimingPointBOList.size() > 2)
            copyTimingPointBOList = copyTimingPointBOList.subList(0, 2);

        for (final TimingPointBO copyTimingPointBO : copyTimingPointBOList) {
            TimingPointBO newTimingPointBO = new TimingPointBO();

            newTimingPointBO = copyTimingPointBO.clone();
            newTimingPointBO.setMenuOffer(menuOffer);
            // /
            newTimingPointBO.setAuthorizationLetter(menuOffer.getAuthorizationLetter());

            timingPointBOList.add(newTimingPointBO);
        }

        return timingPointBOList;
    }

    /**
     * Get the Vehicle
     */
    private VehicleBO retrieveVehicle() {
        final String vehicleProductTypeCode = "C";
        final String vehicleLineCode = "VL-ZF";
        final Integer vehicleModelYear = 2011;
        final List<VehicleRO> vehicleList =
                PDO_DOMAIN_TEST_AS.queryMany(VehicleNamedQueryConfig.queryVehicleByProductTypeVehicleLineModelYear(
                        vehicleProductTypeCode, vehicleLineCode,
                        vehicleModelYear));
        final VehicleRO vehicleRO = vehicleList.get(0);
        final VehicleBO vehicleBO =
                PDO_DOMAIN_TEST_AS.preBindAssociateLookup(vehicleRO);

        return vehicleBO;
    }

    /**
     * create the new Feature
     */
    private FeatureBO createFeatureBO(final String featureCode,
            final FamilyBO familyBO) {
        final FeatureBO newFeatureBO = new FeatureBO();
        final Calendar calendar = Calendar.getInstance();
        final GlobalFeatureRO globalFeatureRO =
                PDO_DOMAIN_TEST_AS.queryOne(GlobalFeatureNamedQueryConfig.queryGlobalFeatureByCode(featureCode));
        final GlobalFeatureBO globalFeatureBO =
                PDO_DOMAIN_TEST_AS.preBindAssociateLookup(globalFeatureRO);

        newFeatureBO.setCreateTime(calendar);
        newFeatureBO.setCreateUser(this.userid);
        newFeatureBO.setFamily(familyBO);
        newFeatureBO.setGlobalFeature(globalFeatureBO);
        newFeatureBO.setIsViewQualifierFlag(false);
        newFeatureBO.setLastUpdateTime(calendar);
        newFeatureBO.setLastUpdateUser(this.userid);
        newFeatureBO.setPositionInFamily(2);

        return newFeatureBO;

    }

}
