package com.nyu.jing.ps1;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Useful methods for Book Library Including insert, remove, searchByName,
 * searchByAddress, searchByPhone, searchByEmail, searchByNote, read, save and
 * AddToJSONSArray
 * 
 * @author Jing Liu
 */

public class BookLibrary {
  ArrayList<Entry> addressSheet;

  private BookLibrary() {
    addressSheet = new ArrayList<Entry>();
  }
  
  public ArrayList<Entry> getAddressSheet() {
    return addressSheet;
  }

  public void setAddressSheet(ArrayList<Entry> addressSheet) {
    this.addressSheet = addressSheet;
  }

  /**
   * create an empty addresslibrary BookLibrary with the given name
   * 
   * @return a new instance of the BookLibrary
   */

  public static BookLibrary creatBookLibrary() {
    return new BookLibrary();
  }

  /**
   * Add an entry to the BookLibrary
   * 
   * @param entry
   *          The entry to be added
   */
  public void insert(Entry entry) {
    addressSheet.add(entry);
  }

  /**
   * Remove an entry to the BookLibrary
   * 
   * @param entry
   *          The entry to be removed
   */
  public void remove(Entry entry) {
    addressSheet.remove(entry);
  }

  /**
   * Search for an entry by the given name
   * 
   * @param findByName
   *          The name you want to search
   * @return the first entry with the name, or null if not found
   */
  public Entry searchByName(String findByName) {
    for (int i = 0; i < addressSheet.size(); i++) {
      if (findByName.equals(addressSheet.get(i).getName())) {
        return addressSheet.get(i);
      }
    }
    return null;
  }

  /**
   * Search for an entry by the given address
   * 
   * @param findByAddress
   *          The address you want to search
   * @return the first entry with the postalAddress, or null if not found
   */
  public Entry searchByAddress(String findByAddress) {
    for (int i = 0; i < addressSheet.size(); i++) {
      if (findByAddress.equals(addressSheet.get(i).getAddress())) {
        return addressSheet.get(i);
      }
    }
    return null;
  }

  /**
   * Search for an entry by the given number
   * 
   * @param findByPhone
   *          The phone number you want to search
   * @return the first entry with the phoneNumber, or null if not found
   */
  public Entry searchByPhone(String findByPhone) {
    for (int i = 0; i < addressSheet.size(); i++) {
      if (findByPhone.equals(addressSheet.get(i).getPhoneNumber())) {
        return addressSheet.get(i);
      }
    }
    return null;
  }

  /**
   * Search for an entry by the given email
   * 
   * @param findByEmail
   *          The email you want to search
   * @return the first entry with the email, or null if not found
   */
  public Entry searchByEmail(String findByEmail) {
    for (int i = 0; i < addressSheet.size(); i++) {
      if (findByEmail.equals(addressSheet.get(i).getEmail())) {
        return addressSheet.get(i);
      }
    }
    return null;
  }

  /**
   * Search for an entry by the given note
   * 
   * @param findByNote
   *          the note you want to search
   * @return the first entry with the note, or null if not found
   */
  public Entry searchByNote(String findByNote) {
    for (int i = 0; i < addressSheet.size(); i++) {
      if (findByNote.equals(addressSheet.get(i).getNote())) {
        return addressSheet.get(i);
      }
    }
    return null;
  }

  /**
   * Read a booklibrary from a file
   * 
   * @param readpath
   *          the file's path which you want to read
   * @return Whether the read is successful or not
   */
  public boolean read(String readpath) {
    addressSheet = new ArrayList<Entry>();
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader(readpath));
      JSONArray jsonarray = (JSONArray) obj;
      for (Object tmpObj : jsonarray) {
        JSONObject jsonObj = (JSONObject) tmpObj;
        String name = (String) jsonObj.get("name");
        String postalAddress = (String) jsonObj.get("postalAddress");
        String phoneNumber = (String) jsonObj.get("phoneNumber");
        String emailAddress = (String) jsonObj.get("email");
        String note = (String) jsonObj.get("note");
        Entry address = new Entry(name, postalAddress, phoneNumber,
            emailAddress, note);
        addressSheet.add(address);
      }
      return true;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * save a booklibrary to a file
   * 
   * @param fileSavedPath
   *          the path of the file which you want ot save
   */
  public void save(String fileSavedPath) {
    FileWriter fw = null;
    try {
      File file = new File(fileSavedPath);
      if (!file.exists()) {
        file.createNewFile();
      }
      fw = new FileWriter(file.getAbsoluteFile());
      String addStr = AddToJSONSArray(addressSheet).toJSONString();
      fw.write(addStr);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fw != null) {
          fw.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * help method to read which can convert address sheet to a JSON list
   * 
   * @param addressSheet
   * @return a JSONArray list if succeed or null if not
   */
  @SuppressWarnings("unchecked")
  private JSONArray AddToJSONSArray(ArrayList<Entry> addressSheet) {
    if (this.addressSheet != null) {
      JSONArray list = new JSONArray();
      for (Entry entry : addressSheet) {
        JSONObject obj = new JSONObject();
        obj.put("name", entry.getName());
        obj.put("postalAddress", entry.getAddress());
        obj.put("phoneNumber", entry.getPhoneNumber());
        obj.put("email", entry.getEmail());
        obj.put("note", entry.getNote());     
        list.add(obj);
      }
      return list;
    }
    return null;
  }

}
