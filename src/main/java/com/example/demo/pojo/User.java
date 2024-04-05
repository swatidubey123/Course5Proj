package com.example.demo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_id;
private	String name;
private String email;
//private String password;
private String password;
private String phno;
private String userType;

//commented to see changes in cascade type 
/*
 * @OneToMany(mappedBy = "placeorder", cascade = CascadeType.ALL) List<Medicine>
 * medicines;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name="pres_id", referencedColumnName = "pres_id" ) private
 * Prescription prescription;
 */

//new code with changed cascade type
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<PlaceOrder> placeOrders;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "pres_id")
private Prescription prescription;

@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private UserAccountBalance accountBalance;

@Override
public String toString() {
    return "User{" +
            "user_id=" + user_id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", phno='" + phno + '\'' +
            ", userType='" + userType + '\'' +
            // Include only relevant fields here, avoiding cyclic references
            '}';
}

/*
 * @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) List<Prescription>
 * prescriptions;
 */


}
