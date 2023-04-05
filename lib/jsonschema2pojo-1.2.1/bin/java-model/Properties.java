import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_id",
    "index",
    "guid",
    "isActive",
    "balance",
    "picture",
    "age",
    "eyeColor",
    "name",
    "gender",
    "company",
    "email",
    "phone",
    "address",
    "about",
    "registered",
    "latitude",
    "longitude",
    "tags",
    "friends",
    "greeting",
    "favoriteFruit"
})
public class Properties {

    @JsonProperty("_id")
    private Id id;
    @JsonProperty("index")
    private Index index;
    @JsonProperty("guid")
    private Guid guid;
    @JsonProperty("isActive")
    private IsActive isActive;
    @JsonProperty("balance")
    private Balance balance;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("age")
    private Age age;
    @JsonProperty("eyeColor")
    private EyeColor eyeColor;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("email")
    private Email email;
    @JsonProperty("phone")
    private Phone phone;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("about")
    private About about;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("latitude")
    private Latitude latitude;
    @JsonProperty("longitude")
    private Longitude longitude;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("friends")
    private Friends friends;
    @JsonProperty("greeting")
    private Greeting greeting;
    @JsonProperty("favoriteFruit")
    private FavoriteFruit favoriteFruit;

    @JsonProperty("_id")
    public Id getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("index")
    public Index getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Index index) {
        this.index = index;
    }

    @JsonProperty("guid")
    public Guid getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    @JsonProperty("isActive")
    public IsActive getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("balance")
    public Balance getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @JsonProperty("picture")
    public Picture getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @JsonProperty("age")
    public Age getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Age age) {
        this.age = age;
    }

    @JsonProperty("eyeColor")
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    @JsonProperty("eyeColor")
    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("email")
    public Email getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(Email email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public Phone getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("about")
    public About getAbout() {
        return about;
    }

    @JsonProperty("about")
    public void setAbout(About about) {
        this.about = about;
    }

    @JsonProperty("registered")
    public Registered getRegistered() {
        return registered;
    }

    @JsonProperty("registered")
    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    @JsonProperty("latitude")
    public Latitude getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Latitude latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Longitude getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Longitude longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @JsonProperty("friends")
    public Friends getFriends() {
        return friends;
    }

    @JsonProperty("friends")
    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    @JsonProperty("greeting")
    public Greeting getGreeting() {
        return greeting;
    }

    @JsonProperty("greeting")
    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    @JsonProperty("favoriteFruit")
    public FavoriteFruit getFavoriteFruit() {
        return favoriteFruit;
    }

    @JsonProperty("favoriteFruit")
    public void setFavoriteFruit(FavoriteFruit favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("index");
        sb.append('=');
        sb.append(((this.index == null)?"<null>":this.index));
        sb.append(',');
        sb.append("guid");
        sb.append('=');
        sb.append(((this.guid == null)?"<null>":this.guid));
        sb.append(',');
        sb.append("isActive");
        sb.append('=');
        sb.append(((this.isActive == null)?"<null>":this.isActive));
        sb.append(',');
        sb.append("balance");
        sb.append('=');
        sb.append(((this.balance == null)?"<null>":this.balance));
        sb.append(',');
        sb.append("picture");
        sb.append('=');
        sb.append(((this.picture == null)?"<null>":this.picture));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("eyeColor");
        sb.append('=');
        sb.append(((this.eyeColor == null)?"<null>":this.eyeColor));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null)?"<null>":this.company));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null)?"<null>":this.phone));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("about");
        sb.append('=');
        sb.append(((this.about == null)?"<null>":this.about));
        sb.append(',');
        sb.append("registered");
        sb.append('=');
        sb.append(((this.registered == null)?"<null>":this.registered));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("friends");
        sb.append('=');
        sb.append(((this.friends == null)?"<null>":this.friends));
        sb.append(',');
        sb.append("greeting");
        sb.append('=');
        sb.append(((this.greeting == null)?"<null>":this.greeting));
        sb.append(',');
        sb.append("favoriteFruit");
        sb.append('=');
        sb.append(((this.favoriteFruit == null)?"<null>":this.favoriteFruit));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.latitude == null)? 0 :this.latitude.hashCode()));
        result = ((result* 31)+((this.greeting == null)? 0 :this.greeting.hashCode()));
        result = ((result* 31)+((this.about == null)? 0 :this.about.hashCode()));
        result = ((result* 31)+((this.index == null)? 0 :this.index.hashCode()));
        result = ((result* 31)+((this.registered == null)? 0 :this.registered.hashCode()));
        result = ((result* 31)+((this.isActive == null)? 0 :this.isActive.hashCode()));
        result = ((result* 31)+((this.picture == null)? 0 :this.picture.hashCode()));
        result = ((result* 31)+((this.friends == null)? 0 :this.friends.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.favoriteFruit == null)? 0 :this.favoriteFruit.hashCode()));
        result = ((result* 31)+((this.balance == null)? 0 :this.balance.hashCode()));
        result = ((result* 31)+((this.eyeColor == null)? 0 :this.eyeColor.hashCode()));
        result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.guid == null)? 0 :this.guid.hashCode()));
        result = ((result* 31)+((this.company == null)? 0 :this.company.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.age == null)? 0 :this.age.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.longitude == null)? 0 :this.longitude.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties) == false) {
            return false;
        }
        Properties rhs = ((Properties) other);
        return (((((((((((((((((((((((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address)))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.latitude == rhs.latitude)||((this.latitude!= null)&&this.latitude.equals(rhs.latitude))))&&((this.greeting == rhs.greeting)||((this.greeting!= null)&&this.greeting.equals(rhs.greeting))))&&((this.about == rhs.about)||((this.about!= null)&&this.about.equals(rhs.about))))&&((this.index == rhs.index)||((this.index!= null)&&this.index.equals(rhs.index))))&&((this.registered == rhs.registered)||((this.registered!= null)&&this.registered.equals(rhs.registered))))&&((this.isActive == rhs.isActive)||((this.isActive!= null)&&this.isActive.equals(rhs.isActive))))&&((this.picture == rhs.picture)||((this.picture!= null)&&this.picture.equals(rhs.picture))))&&((this.friends == rhs.friends)||((this.friends!= null)&&this.friends.equals(rhs.friends))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.favoriteFruit == rhs.favoriteFruit)||((this.favoriteFruit!= null)&&this.favoriteFruit.equals(rhs.favoriteFruit))))&&((this.balance == rhs.balance)||((this.balance!= null)&&this.balance.equals(rhs.balance))))&&((this.eyeColor == rhs.eyeColor)||((this.eyeColor!= null)&&this.eyeColor.equals(rhs.eyeColor))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.guid == rhs.guid)||((this.guid!= null)&&this.guid.equals(rhs.guid))))&&((this.company == rhs.company)||((this.company!= null)&&this.company.equals(rhs.company))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.age == rhs.age)||((this.age!= null)&&this.age.equals(rhs.age))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.longitude == rhs.longitude)||((this.longitude!= null)&&this.longitude.equals(rhs.longitude))));
    }

}
