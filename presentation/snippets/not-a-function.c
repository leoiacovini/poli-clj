void fill_message(Person* person) {
    int age_in_seconds = person->age;
    person->message = person->name + " is " + (int) age_in_seconds/3600 + "years old";
}
