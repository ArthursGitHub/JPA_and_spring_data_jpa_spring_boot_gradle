package org.learn.bookpub.controller;

import org.learn.bookpub.envelope.Envelope;
import org.learn.bookpub.exception.RoomUnAvailableException;
import org.learn.bookpub.model.RoomModel;
import org.learn.bookpub.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomsResource {

	@Autowired
	RoomService roomService;
//  @RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
//  public RoomDTO getRoom(@PathVariable("roomId") String roomId) {
//    RoomDTO room = ...
//    // omitted for sake of clarity
//    return room;
//  }
	
//	@RequestMapping(value = "/{roomName}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	  public Envelope<RoomModel> getRoomByName(@PathVariable("roomName") String roomName) {
//		  System.out.println("getRoomByName called");
//		  String status  = "";
//		  try{
//			  	RoomModel room = roomService.getRoomByName(roomName);
//			  	status = "Success";
//			  	return new Envelope(status, room);		
//			} catch(Exception e){
//				status = "Failed";
//				return new Envelope(status, e.getMessage());
//			}
//	  }
  
  @RequestMapping(value = "/{roomId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
  public Envelope<RoomModel> getRoom(@PathVariable("roomId") int roomId) {
	  System.out.println("getRoom called");
	  String status  = "";
	  try{
		  	RoomModel room = roomService.getRoom(roomId);
		  	status = "Success";
		  	return new Envelope(status, room);		
		} catch(Exception e){
			e.printStackTrace();
			status = "Failed";
			return new Envelope(status, e.getMessage());
		}
  }
  
  @Transactional("org.springframework.orm.jpa.JpaTransactionManager")
  @RequestMapping(method = RequestMethod.POST, consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		  			MediaType.APPLICATION_JSON_VALUE}, produces= MediaType.TEXT_PLAIN_VALUE)
  public void createRoom(@RequestBody RoomModel room) {
	  System.out.println("roomService : "+ roomService);
	  roomService.createRoom(room);	  
  }
//  
//  @RequestMapping(value = "/{roomId}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, 
//		  produces=MediaType.APPLICATION_JSON_VALUE)
//  public Room updateRoom(@RequestBody Room room, @PathVariable("roomId") int roomId) {
//    return RoomService.updateRoom(room, roomId);
//  }
//  
//  @RequestMapping(value="/{roomId}", method=RequestMethod.DELETE)
//  public void deleteRoom(@PathVariable("roomId") int roomId){
//	  RoomService.deleteRoom(roomId);
//  }
  
}