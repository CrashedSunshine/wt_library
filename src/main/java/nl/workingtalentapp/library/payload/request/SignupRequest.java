package nl.workingtalentapp.library.payload.request;

import javax.validation.constraints.*;
import java.util.Set;

public class SignupRequest {

  private String name;

  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  private String userRole;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  private String photo;
  private String functie;
  private String phoneNumber;
  private String linkedinURL;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public String getPhoto() {
    return this.photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getFunctie() {
    return this.functie;
  }

  public void setFunctie(String functie) {
    this.functie = functie;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getLinkedinURL() {
    return this.linkedinURL;
  }

  public void setLinkedinURL(String linkedinURL) {
    this.linkedinURL = linkedinURL;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}
