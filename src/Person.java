class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Person{");
        sb.append("name='");
        sb.append(name);
        sb.append('\'');
        sb.append(", family='");
        sb.append(family);
        sb.append('\'');
        sb.append(", age=");
        sb.append(age);
        sb.append(", sex=");
        sb.append(sex);
        sb.append(", education=");
        sb.append(education);
        sb.append('}');

        return sb.toString();

        /*return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';*/
    }
}