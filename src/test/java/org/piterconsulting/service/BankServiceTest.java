//package org.piterconsulting.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.piterconsulting.repository.ClientSpringJpaRepository;
//import org.piterconsulting.repository.entity.Account;
//import org.piterconsulting.repository.entity.Client;
//
//import static java.util.Collections.singletonList;
//import static org.mockito.Mockito.*;
//
//public class BankServiceTest {
//    BankService service;
//    private ClientSpringJpaRepository repository;
//
//    @BeforeEach
//    public void setup()
//    {
//        repository = mock(ClientSpringJpaRepository.class);
//        ClientMapper mapper = mock(ClientMapper.class);
//        service=new BankService(repository,mapper );
//
//    }
//    @Test
//    public void VerifyIFTwoOFMailsAreEquals()
//    {
//        //given
//        final String emailFrom= "mail@piotr";
//        final String emailTo=   "mail@pawel";
//        final Client clientFrom=new Client(
//                "Piotr",
//                emailFrom,
//                singletonList(new Account(4000,"PLN"))
//        );
//        final Client clientTo=new Client(
//                "Pawel",
//                emailTo,
//               singletonList(new Account(1000,"PLN"))
//        );
//        double amount=1000;
//        when(repository.findByMail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByMail(emailTo)).thenReturn(clientTo);
//        //when
//        service.transfer(emailFrom,emailTo,amount);
//        //then
//        final Client actualclientfrom = service
//                .findByEmail(emailFrom);
//        final Client actualcleientto = service
//                .findByEmail(emailTo);
//        final Client expectedcleintfrom = new Client(
//                "Piotr",
//                "mail@piotr",
//                singletonList(new Account(3000,"PLN"))
//        );
//        final Client expectedclientto = new Client(
//                "Pawel",
//                "mail@pawel",
//                singletonList(new Account(2000,"PLN"))
//        );
//       verify(repository).save(expectedcleintfrom);
//       verify(repository).save(expectedclientto);
//
//    }
//    @Test
//    public void transfer_allFounds_foundsTransferred(){
//        //given
//        final String emailFrom= "mail@piotr";
//        final String emailTo=   "mail@pawel";
//        final Client clientFrom=new Client("Piotr",emailFrom,singletonList(new Account(1000,"PLN")));
//        final Client clientTo=new Client("Pawel",emailTo,singletonList(new Account(3000,"PLN")));
//
//        double amount =1000;
//
//        when(repository.findByMail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByMail(emailTo)).thenReturn(clientTo);
//
//        //when
//        service.transfer(emailFrom,emailTo,amount);
//        //then
//
//        final Client expectedcleintfrom = new Client(
//                "Piotr",
//                "mail@piotr",
//                singletonList(new Account(0,"PLN")));
//        final Client expectedclientto = new Client(
//                "Pawel",
//                "mail@pawel",
//                singletonList(new Account(4000,"PLN")));
//        verify(repository).save(expectedcleintfrom);
//        verify(repository).save(expectedclientto);
//
//
//    }
//    @Test
//    public void transfer_notEnoughhFound_foundTransffered(){
//
//        final String emailFrom= "mail@piotr";
//        final String emailTo=   "mail@pawel";
//        final Client clientFrom=new Client("Piotr",emailFrom,singletonList(new Account(900,"PLN")));
//        final Client clientTo=new Client("Pawel",emailTo,singletonList(new Account(3000,"PLN")));
//        when(repository.findByMail(emailFrom)).thenReturn(clientFrom);
//        when(repository.findByMail(emailTo)).thenReturn(clientTo);
//
//
//        double amount =1000;
//        //when/then
//        Assertions.assertThrows(NoSufficientFundsException.class,
//                () -> service.transfer(emailFrom,emailTo,amount));
//
//    }
//
//    @Test
//    public void transfer_minusAmount_Transferred(){
//
//        final String emailFrom= "mail@piotr";
//        final String emailTo=   "mail@pawel";
//
//        double amount=-190;
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> service.transfer(emailFrom,emailTo,amount));
//    }
//    @Test
//    public void transfer_ToSameGuys_thrownException(){
//        final String emailFrom= "mail@piotr";
//        //when then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,() -> service.transfer(emailFrom,emailFrom,10)
//        );
//    }
////    @Test
////    public void showIfThatMailExistInBaseTest()
////    {
////        Client client = new Client("Tomek","Tomek@tomek",2000);
////
////        Assertions.assertThrows(
////                NoSuchElementException.class,() -> service.findByEmail(client.getMail())
////        );
////
////    }
////
////    @Test
////    public void thisManAlreadyExistInBaseTest()
////    {
////        //given
////        Client k1 =new Client("Tomek","tomek@tomek",422);
////        service.save(k1);
////
////        //when
////        Client k2=new Client("Tomek","tomek@tomek",422);
////
////        Assertions.assertThrows(thisManAlreadyExistInBaseException.class,() ->service.save(k2));
////    }
////
////    @Test
////    public void SamemailsTest(){
////        Client k1 =new Client("Tomek","tomek@tomek",422);
////        service.save(k1);
////
////        //when
////        Client k2=new Client("Pawel","tomek@tomek",222);
////
////        Assertions.assertThrows(SameEmailsException.class,() -> service.save(k2));
////
////    }
////    @Test
////    public void NullEmailsTest(){
////        Client k1 = new Client("sama",null,221);
////
////        Assertions.assertThrows(NullPointerException.class,() -> service.save(k1));
////    }
////    @Test
////    public void NullNamesTest(){
////        Client k1 = new Client(null,"sd",221);
////
////        Assertions.assertThrows(NullPointerException.class,() -> service.save(k1));
////    }
////
////    public void ISMAnInBaseToTransferAmount(){
////        Client k1 = new Client("Sam","Well",200);
////        Client k2 = new Client("Tom","Dell",200);
//////        service.save(k1);
////        Assertions.assertThrows(NullPointerException.class,() -> service.transfer(k1.getMail(), k2.getMail(), 100));
////    }
//    @Test
//    public void withdraw_correctAmount_balanceChangedCorrectly(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("alek",email,singletonList(new Account(100,"PLN")));
//        when(repository.findByMail(email)).thenReturn(client);
//    //when
//        service.withdraw(email,50);
//        //then
//        Client expectedClient= new Client("alek",email,singletonList(new Account(50,"PLN")));
//
//
//    }
////    @Test
////    public void withdraw_AllBalance_balanceSetZero(){
////        //given
////        final String email = "a@a.pl";
////        final Client client = new Client("alek",email,100);
////        clients.add(client);
////        //when
////        service.withdraw(email,100);
////        //then
////        Client expectedClient= new Client("alek",email,0);
////        Assertions.assertTrue(clients.contains(expectedClient));
////
////    }
////    @Test
////    public void withdraw_negativeZerpAmount_throwsIllegalArgumentException() {
////        //given
////        final String email = "a@a.pl";
////        final Client client = new Client("alek", email, 100);
////        clients.add(client);
////        //when
////        final int amount = 0;
////        //then
////        Assertions.assertThrows(
////                IllegalArgumentException.class,
////                () -> service.withdraw(email, amount)
////        );
////    }
////        @Test
////        public void withdraw_BiggerThanBalance_throwsIllegalArgumentException(){
////            //given
////            final String email = "a@a.pl";
////            final Client client = new Client("alek",email,100);
////            clients.add(client);
////            //when
////            final int amount = 200;
////            //then
////            Assertions.assertThrows(
////                    NoSufficientFundsException.class,
////                    () -> service.withdraw(email,amount)
////            );
////    }
////    @Test
////    public void withdraw_NoMailInBase_throwsIllegalArgumentException(){
////        //given
////        final String email = "a@a.pl";
////        final Client client = new Client("alek",email,100);
////        clients.add(client);
////        //when
////        final int amount = 200;
////        //then
////        Assertions.assertThrows(
////                NoSuchElementException.class,
////                () -> service.withdraw("kekw",amount)
////        );
////    }
////
////    @Test
////    public void withdraw_UpperCaseEmail(){
////        //given
////        final String email = "A@A.PL";
////        final Client client = new Client("alek","a@a.pl",100);
////        clients.add(client);
////        //when
////        final int amount = 50;
////        //then
////        service.withdraw(email,amount);
////        Client expectedclient = new Client("alek","a@a.pl",50);
////        Assertions.assertTrue(clients.contains(expectedclient));
////
////    }
////    @Test
////    public void withdraw_NullMail_IllegalArgumentException(){
////        //given
////        final String email=null;
////        final int amount = 1000;
////        //then/when
////        Assertions.assertThrows(IllegalArgumentException.class,() -> service.withdraw(email,amount));
////
////    }
////    @Test
////    public void withdraw_CorrectAmount_FloatingPoint(){
////        //given
////        final String email = "a@a.pl";
////        final Client client = new Client("alek","a@a.pl",100);
////        clients.add(client);
////        //when
////        final double amount = 50.5;
////        //then
////        service.withdraw(email,amount);
////        Client expectedclient = new Client("alek","a@a.pl",49.5);
////        final Client client1 = clients.get(0);
////        Assertions.assertEquals(expectedclient,client1);
////
////    }
////    @Test
////    public void deletePerson_fromBase(){
////        final String mail = "a@a.pl";
////        Client k1 = new Client("ala", mail,100);
////        clients.add(k1);
////        Assertions.assertThrows(NoSuchElementException.class,() -> service.delete("data"));
////    }
////    @Test
////    public void delete_NullEmail(){
////        final String mail = null;
////        Client k1 = new Client("ala", null,100);
////        clients.add(k1);
////        Assertions.assertThrows(IllegalArgumentException.class,() -> service.delete(mail));
////    }
////    @Test
////    public void deletedClientsucceeded()
////    {
////        final String mail = "a@a.pl";
////        Client k1 = new Client("ala", mail,0);
////        clients.add(k1);
////        service.delete(mail);
////        Assertions.assertFalse(clients.contains(k1));
////    }
////    @Test
////    public void deletedClientBigLetterssucceeded()
////    {
////        final String mail = "a@a.pl";
////        Client k1 = new Client("ala", mail,0);
////        clients.add(k1);
////        service.delete("A@A.PL");
////        Assertions.assertFalse(clients.contains(k1));
////    }
//
//
//
//
//}
