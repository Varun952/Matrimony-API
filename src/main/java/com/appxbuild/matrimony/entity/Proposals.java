package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "proposals")
public class Proposals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Agencies agencies;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "age_value")
    private int ageValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blood_group_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private BloodGroups bloodGroups;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Genders gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marital_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private MaritalStatuses maritalStatuses;

    @Column(name = "children")
    private int children;

    @Column(name = "children_desc")
    private String childrenDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "financial_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private FinancialStatuses financialStatuses;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gotra_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Gotras gotras;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "body_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private BodyTypes bodyType;

    @Column(name = "height")
    private int height;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complexion_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Complexions complexionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Drinks drinks;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "occupation_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Occupations occupations;

    @Column(name = "occupation_desc")
    private String occupationDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "smoke_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Smokes smokes;

    @Column(name = "weight")
    private int weight;

    @Column(name = "preferences")
    private String preferences;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Educations educations;

    @Column(name = "physical_disability")
    private byte physicalDisability;

    @Column(name = "physical_disability_desc")
    private String physicalDisabilityDesc;

    @Column(name = "chronic_disease")
    private byte chronicDisease;

    @Column(name = "chronic_disease_desc")
    private String chronicDiseaseDesc;

    @Column(name = "joint_family_interest")
    private byte jointFamilyInterest;

    @Column(name = "kundli_interest")
    private byte kundliInterest;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kundli_document_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Documents documents;

    @Column(name = "foreign_country_interest")
    private byte foreignCountryInterest;

    @Column(name = "intercast_interest")
    private byte intercastInterest;

    @Column(name = "vegetarian")
    private byte vegetarian;

    @Column(name = "specs")
    private byte specs;

    @Column(name = "married_brothers")
    private int marriedBrothers;

    @Column(name = "unmarried_brothers")
    private int unmarriedBrothers;

    @Column(name = "married_sisters")
    private int marriedSisters;

    @Column(name = "unmarried_sisters")
    private int unmarriedSisters;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_information")
    private String fatherInformation;

    @Column(name = "father_email")
    private String fatherEmail;

    @Column(name = "mother_information")
    private String motherInformation;

    @Column(name = "brothers_information")
    private String brothersInformation;

    @Column(name = "sisters_information")
    private String sistersInformation;

    @Column(name = "mother_maiden_name")
    private String motherMaidenName;

    @Column(name = "is_parents_marriage_intercast")
    private byte isParentsMarriageIntercast;

    @Column(name = "current_address")
    private String currentAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Countries countries;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_state_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private States currentStateId;

    @Column(name = "current_state_name")
    private String currentStateName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_city_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Cities currentCityId;

    @Column(name = "current_city_name")
    private String currentCityName;

    @Column(name = "current_pincode")
    private String currentPincode;

    @Column(name = "permanent_address")
    private String permanentAddress;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Countries permanentCountry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_state_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private States permanentState;

    @Column(name = "permanent_state_name")
    private String permanentStateName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_city_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Cities permanentCity;

    @Column(name = "permanent_city_name")
    private String permanentCityName;

    @Column(name = "permanent_pincode")
    private String permanentPincode;

    @Column(name = "father_mobile")
    private String fatherMobile;

    @Column(name = "mother_mobile")
    private String motherMobile;

    @Column(name = "sister_mobile")
    private String sisterMobile;

    @Column(name = "brother_mobile")
    private String brotherMobile;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "yearly_income")
    private int yearlyIncome;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "birth_date_time")
    private LocalDateTime birthDateTime;

    @Column(name = "birth_name")
    private String birthName;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "mangal")
    private byte mangal;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "approved")
    private byte approved;

    @Column(name = "closure")
    private byte closure;

    @Column(name = "closure_reason")
    private String closureReason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_thumbnail_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Thumbnails primaryThumbnail;

    @Column(name = "reference_1_desc")
    private String reference1Desc;

    @Column(name = "reference_2_desc")
    private String reference2Desc;

    @Column(name = "designation_name")
    private String designationName;

    @Column(name = "degree_desc")
    private String degreeDesc;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private Users users;


    // default constructor
    public Proposals() {

    }

    public Proposals( String shortCode, String aboutMe, int ageValue, int children, String childrenDesc, int height, String occupationDesc, int weight, String preferences, byte physicalDisability, String physicalDisabilityDesc, byte chronicDisease, String chronicDiseaseDesc, byte jointFamilyInterest, byte kundliInterest, byte foreignCountryInterest, byte intercastInterest, byte vegetarian, byte specs, int marriedBrothers, int unmarriedBrothers, int marriedSisters, int unmarriedSisters, String fatherName, String motherName, String fatherInformation, String fatherEmail, String motherInformation, String brothersInformation, String sistersInformation, String motherMaidenName, byte isParentsMarriageIntercast, String currentAddress, String currentStateName, String currentCityName, String currentPincode, String permanentAddress, String permanentStateName, String permanentCityName, String permanentPincode, String fatherMobile, String motherMobile, String sisterMobile, String brotherMobile, String email, String mobile, int yearlyIncome, String companyName, String companyLocation, LocalDateTime birthDateTime, String birthName, String birthPlace, byte mangal, String hobbies, byte approved, byte closure, String closureReason, String reference1Desc, String reference2Desc, String designationName, String degreeDesc, LocalDateTime created, LocalDateTime modified) {
        this.shortCode = shortCode;
        this.aboutMe = aboutMe;
        this.ageValue = ageValue;
        this.children = children;
        this.childrenDesc = childrenDesc;
        this.height = height;
        this.occupationDesc = occupationDesc;
        this.weight = weight;
        this.preferences = preferences;
        this.physicalDisability = physicalDisability;
        this.physicalDisabilityDesc = physicalDisabilityDesc;
        this.chronicDisease = chronicDisease;
        this.chronicDiseaseDesc = chronicDiseaseDesc;
        this.jointFamilyInterest = jointFamilyInterest;
        this.kundliInterest = kundliInterest;
        this.foreignCountryInterest = foreignCountryInterest;
        this.intercastInterest = intercastInterest;
        this.vegetarian = vegetarian;
        this.specs = specs;
        this.marriedBrothers = marriedBrothers;
        this.unmarriedBrothers = unmarriedBrothers;
        this.marriedSisters = marriedSisters;
        this.unmarriedSisters = unmarriedSisters;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherInformation = fatherInformation;
        this.fatherEmail = fatherEmail;
        this.motherInformation = motherInformation;
        this.brothersInformation = brothersInformation;
        this.sistersInformation = sistersInformation;
        this.motherMaidenName = motherMaidenName;
        this.isParentsMarriageIntercast = isParentsMarriageIntercast;
        this.currentAddress = currentAddress;
        this.currentStateName = currentStateName;
        this.currentCityName = currentCityName;
        this.currentPincode = currentPincode;
        this.permanentAddress = permanentAddress;
        this.permanentStateName = permanentStateName;
        this.permanentCityName = permanentCityName;
        this.permanentPincode = permanentPincode;
        this.fatherMobile = fatherMobile;
        this.motherMobile = motherMobile;
        this.sisterMobile = sisterMobile;
        this.brotherMobile = brotherMobile;
        this.email = email;
        this.mobile = mobile;
        this.yearlyIncome = yearlyIncome;
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.birthDateTime = birthDateTime;
        this.birthName = birthName;
        this.birthPlace = birthPlace;
        this.mangal = mangal;
        this.hobbies = hobbies;
        this.approved = approved;
        this.closure = closure;
        this.closureReason = closureReason;
        this.reference1Desc = reference1Desc;
        this.reference2Desc = reference2Desc;
        this.designationName = designationName;
        this.degreeDesc = degreeDesc;
        this.created = created;
        this.modified = modified;
    }

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(int ageValue) {
        this.ageValue = ageValue;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getChildrenDesc() {
        return childrenDesc;
    }

    public void setChildrenDesc(String childrenDesc) {
        this.childrenDesc = childrenDesc;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getOccupationDesc() {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }


    public byte getPhysicalDisability() {
        return physicalDisability;
    }

    public void setPhysicalDisability(byte physicalDisability) {
        this.physicalDisability = physicalDisability;
    }

    public String getPhysicalDisabilityDesc() {
        return physicalDisabilityDesc;
    }

    public void setPhysicalDisabilityDesc(String physicalDisabilityDesc) {
        this.physicalDisabilityDesc = physicalDisabilityDesc;
    }

    public byte getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(byte chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getChronicDiseaseDesc() {
        return chronicDiseaseDesc;
    }

    public void setChronicDiseaseDesc(String chronicDiseaseDesc) {
        this.chronicDiseaseDesc = chronicDiseaseDesc;
    }

    public byte getJointFamilyInterest() {
        return jointFamilyInterest;
    }

    public void setJointFamilyInterest(byte jointFamilyInterest) {
        this.jointFamilyInterest = jointFamilyInterest;
    }

    public byte getKundliInterest() {
        return kundliInterest;
    }

    public void setKundliInterest(byte kundliInterest) {
        this.kundliInterest = kundliInterest;
    }

    public byte getForeignCountryInterest() {
        return foreignCountryInterest;
    }

    public void setForeignCountryInterest(byte foreignCountryInterest) {
        this.foreignCountryInterest = foreignCountryInterest;
    }

    public byte getIntercastInterest() {
        return intercastInterest;
    }

    public void setIntercastInterest(byte intercastInterest) {
        this.intercastInterest = intercastInterest;
    }

    public byte getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(byte vegetarian) {
        this.vegetarian = vegetarian;
    }

    public byte getSpecs() {
        return specs;
    }

    public void setSpecs(byte specs) {
        this.specs = specs;
    }

    public int getMarriedBrothers() {
        return marriedBrothers;
    }

    public void setMarriedBrothers(int marriedBrothers) {
        this.marriedBrothers = marriedBrothers;
    }

    public int getUnmarriedBrothers() {
        return unmarriedBrothers;
    }

    public void setUnmarriedBrothers(int unmarriedBrothers) {
        this.unmarriedBrothers = unmarriedBrothers;
    }

    public int getMarriedSisters() {
        return marriedSisters;
    }

    public void setMarriedSisters(int marriedSisters) {
        this.marriedSisters = marriedSisters;
    }

    public int getUnmarriedSisters() {
        return unmarriedSisters;
    }

    public void setUnmarriedSisters(int unmarriedSisters) {
        this.unmarriedSisters = unmarriedSisters;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherInformation() {
        return fatherInformation;
    }

    public void setFatherInformation(String fatherInformation) {
        this.fatherInformation = fatherInformation;
    }

    public String getFatherEmail() {
        return fatherEmail;
    }

    public void setFatherEmail(String fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

    public String getMotherInformation() {
        return motherInformation;
    }

    public void setMotherInformation(String motherInformation) {
        this.motherInformation = motherInformation;
    }

    public String getBrothersInformation() {
        return brothersInformation;
    }

    public void setBrothersInformation(String brothersInformation) {
        this.brothersInformation = brothersInformation;
    }

    public String getSistersInformation() {
        return sistersInformation;
    }

    public void setSistersInformation(String sistersInformation) {
        this.sistersInformation = sistersInformation;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public byte getIsParentsMarriageIntercast() {
        return isParentsMarriageIntercast;
    }

    public void setIsParentsMarriageIntercast(byte isParentsMarriageIntercast) {
        this.isParentsMarriageIntercast = isParentsMarriageIntercast;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCurrentStateName() {
        return currentStateName;
    }

    public void setCurrentStateName(String currentStateName) {
        this.currentStateName = currentStateName;
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        this.currentCityName = currentCityName;
    }

    public String getCurrentPincode() {
        return currentPincode;
    }

    public void setCurrentPincode(String currentPincode) {
        this.currentPincode = currentPincode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentStateName() {
        return permanentStateName;
    }

    public void setPermanentStateName(String permanentStateName) {
        this.permanentStateName = permanentStateName;
    }

    public String getPermanentCityName() {
        return permanentCityName;
    }

    public void setPermanentCityName(String permanentCityName) {
        this.permanentCityName = permanentCityName;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getFatherMobile() {
        return fatherMobile;
    }

    public void setFatherMobile(String fatherMobile) {
        this.fatherMobile = fatherMobile;
    }

    public String getMotherMobile() {
        return motherMobile;
    }

    public void setMotherMobile(String motherMobile) {
        this.motherMobile = motherMobile;
    }

    public String getSisterMobile() {
        return sisterMobile;
    }

    public void setSisterMobile(String sisterMobile) {
        this.sisterMobile = sisterMobile;
    }

    public String getBrotherMobile() {
        return brotherMobile;
    }

    public void setBrotherMobile(String brotherMobile) {
        this.brotherMobile = brotherMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(int yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public LocalDateTime getBirthDateTime() {
        return birthDateTime;
    }

    public void setBirthDateTime(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public byte getMangal() {
        return mangal;
    }

    public void setMangal(byte mangal) {
        this.mangal = mangal;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {

        this.hobbies = hobbies;
    }

    public byte getApproved() {
        return approved;
    }

    public void setApproved(byte approved) {
        this.approved = approved;
    }

    public byte getClosure() {
        return closure;
    }

    public void setClosure(byte closure) {
        this.closure = closure;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public void setClosureReason(String closureReason) {
        this.closureReason = closureReason;
    }

    public String getReference1Desc() {
        return reference1Desc;
    }

    public void setReference1Desc(String reference1Desc) {
        this.reference1Desc = reference1Desc;
    }

    public String getReference2Desc() {
        return reference2Desc;
    }

    public void setReference2Desc(String reference2Desc) {
        this.reference2Desc = reference2Desc;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDegreeDesc() {
        return degreeDesc;
    }

    public void setDegreeDesc(String degreeDesc) {
        this.degreeDesc = degreeDesc;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Agencies getAgencies() {
        return agencies;
    }

    public void setAgencies(Agencies agencies) {
        this.agencies = agencies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public BloodGroups getBloodGroups() {
        return bloodGroups;
    }

    public void setBloodGroups(BloodGroups bloodGroups) {
        this.bloodGroups = bloodGroups;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public MaritalStatuses getMaritalStatuses() {
        return maritalStatuses;
    }

    public void setMaritalStatuses(MaritalStatuses maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }

    public FinancialStatuses getFinancialStatuses() {
        return financialStatuses;
    }

    public void setFinancialStatuses(FinancialStatuses financialStatuses) {
        this.financialStatuses = financialStatuses;
    }

    public Gotras getGotras() {
        return gotras;
    }

    public void setGotras(Gotras gotras) {
        this.gotras = gotras;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypes bodyType) {
        this.bodyType = bodyType;
    }

    public Complexions getComplexionId() {
        return complexionId;
    }

    public void setComplexionId(Complexions complexionId) {
        this.complexionId = complexionId;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public Occupations getOccupations() {
        return occupations;
    }

    public void setOccupations(Occupations occupations) {
        this.occupations = occupations;
    }

    public Smokes getSmokes() {
        return smokes;
    }

    public void setSmokes(Smokes smokes) {
        this.smokes = smokes;
    }

    public Educations getEducations() {
        return educations;
    }

    public void setEducations(Educations educations) {
        this.educations = educations;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public States getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(States currentStateId) {
        this.currentStateId = currentStateId;
    }

    public Cities getCurrentCityId() {
        return currentCityId;
    }

    public void setCurrentCityId(Cities currentCityId) {
        this.currentCityId = currentCityId;
    }

    public Countries getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(Countries permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public States getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(States permanentState) {
        this.permanentState = permanentState;
    }

    public Cities getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(Cities permanentCity) {
        this.permanentCity = permanentCity;
    }

    public Thumbnails getPrimaryThumbnail() {
        return primaryThumbnail;
    }

    public void setPrimaryThumbnail(Thumbnails primaryThumbnail) {
        this.primaryThumbnail = primaryThumbnail;
    }


    //toString
    @Override
    public String toString() {
        return "Proposals{" +
                "id=" + id +
                ", agencies=" + agencies +
                ", shortCode='" + shortCode + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", ageValue=" + ageValue +
                ", bloodGroups=" + bloodGroups +
                ", gender=" + gender +
                ", maritalStatuses=" + maritalStatuses +
                ", children=" + children +
                ", childrenDesc='" + childrenDesc + '\'' +
                ", financialStatuses=" + financialStatuses +
                ", gotras=" + gotras +
                ", bodyType=" + bodyType +
                ", height=" + height +
                ", complexionId=" + complexionId +
                ", drinks=" + drinks +
                ", occupations=" + occupations +
                ", occupationDesc='" + occupationDesc + '\'' +
                ", smokes=" + smokes +
                ", weight=" + weight +
                ", preferences='" + preferences + '\'' +
                ", educations=" + educations +
                ", physicalDisability=" + physicalDisability +
                ", physicalDisabilityDesc='" + physicalDisabilityDesc + '\'' +
                ", chronicDisease=" + chronicDisease +
                ", chronicDiseaseDesc='" + chronicDiseaseDesc + '\'' +
                ", jointFamilyInterest=" + jointFamilyInterest +
                ", kundliInterest=" + kundliInterest +
                ", documents=" + documents +
                ", foreignCountryInterest=" + foreignCountryInterest +
                ", intercastInterest=" + intercastInterest +
                ", vegetarian=" + vegetarian +
                ", specs=" + specs +
                ", marriedBrothers=" + marriedBrothers +
                ", unmarriedBrothers=" + unmarriedBrothers +
                ", marriedSisters=" + marriedSisters +
                ", unmarriedSisters=" + unmarriedSisters +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", fatherInformation='" + fatherInformation + '\'' +
                ", fatherEmail='" + fatherEmail + '\'' +
                ", motherInformation='" + motherInformation + '\'' +
                ", brothersInformation='" + brothersInformation + '\'' +
                ", sistersInformation='" + sistersInformation + '\'' +
                ", motherMaidenName='" + motherMaidenName + '\'' +
                ", isParentsMarriageIntercast=" + isParentsMarriageIntercast +
                ", currentAddress='" + currentAddress + '\'' +
                ", countries=" + countries +
                ", currentStateId=" + currentStateId +
                ", currentStateName='" + currentStateName + '\'' +
                ", currentCityId=" + currentCityId +
                ", currentCityName='" + currentCityName + '\'' +
                ", currentPincode='" + currentPincode + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", permanentCountry=" + permanentCountry +
                ", permanentState=" + permanentState +
                ", permanentStateName='" + permanentStateName + '\'' +
                ", permanentCity=" + permanentCity +
                ", permanentCityName='" + permanentCityName + '\'' +
                ", permanentPincode='" + permanentPincode + '\'' +
                ", fatherMobile='" + fatherMobile + '\'' +
                ", motherMobile='" + motherMobile + '\'' +
                ", sisterMobile='" + sisterMobile + '\'' +
                ", brotherMobile='" + brotherMobile + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", yearlyIncome=" + yearlyIncome +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", birthDateTime=" + birthDateTime +
                ", birthName='" + birthName + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", mangal=" + mangal +
                ", hobbies='" + hobbies + '\'' +
                ", approved=" + approved +
                ", closure=" + closure +
                ", closureReason='" + closureReason + '\'' +
                ", primaryThumbnail=" + primaryThumbnail +
                ", reference1Desc='" + reference1Desc + '\'' +
                ", reference2Desc='" + reference2Desc + '\'' +
                ", designationName='" + designationName + '\'' +
                ", degreeDesc='" + degreeDesc + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", users=" + users +
                '}';
    }
}
