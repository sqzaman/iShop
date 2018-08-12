export class Address {
    id: number;
    street: string;
    city: string;
    zip: string;
    state: string;
    country: string;	

    constructor(id: number, street: string, city: string, zip: string, state: string, country: string) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
    }
}