package ro.remro.sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.remro.model.Antreprenor;
import ro.remro.model.Car;
import ro.remro.model.Client;
import ro.remro.model.Remorca;
import ro.remro.repository.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


@Component
@FxmlView("sample.fxml")
public class Controller {
    public PasswordField pswfield;
    public Label lblName;
    public Label lblPasswaor;
    public Button btnLogin;
    public MenuItem mnuItemLogin;
    public Tab tabMain;
    public Tab tabLogin;
    public TabPane tabPane;

    public MenuItem tabLogOut;
    public TextField txtFieldCarNumber;
    public Label lbCarNumber;
    public TextField txtFieldMaxWeigth;
    public Label lbMaxWeigth;
    public TextField txtfieldUserName;
    public ComboBox comboBoxCarNumber;
    public Label lbUtilWeigth1;
    public TextField txtFieldUtilWeigth1;

    public MenuItem menuItemAddClient;
    public TextField txtNumeClient;
    public Label lblNameClient;
    public Label lblPrenumeClient;
    public TextField txtPreNumeClient;
    public Tab tabAdaugClient;
    public Label lblNumeClient;
    public TextField txtPrenumeClient;
    public Button btnSaveClient;
    public TextField txtSerieBuletin;
    public Label lblSerieBuletin;
    public Label lblCNPClient;
    public Label lblTelClient;
    public TextField txtCNPClient;
    public TextField txtTelClient;
    public Tab tabAdaugCar;
    public Label lblCarNumber;
    public Label lblCarRegNr;
    public TextField txtCarNumber;
    public TextField txtCarRegNr;
    public Button btnSaveCar;
    public TextField txtCarOem;
    public Label lblCarOem;
    public Label lblDataVerificare;
    public TextField txtDataVerificare;
    public ComboBox comboBoxClientCNP;
    public TextField txtFieldClientSurname;
    public TextField txtFieldNumeClient;
    public Tab tabDeleteCar;
    public AnchorPane anchorPaneDelRemorca;
    public Label lblSelectDelCar;
    public ComboBox cmbCartoDelete;
    public Button btnDeleteRemorca;
    public Tab tabUpdateClientandOwner;
    public Tab tabDeleteREmorca;
    public MenuBar menuBarUpdateVCientOwner;
    public MenuItem menuItemRemoveRemorca;
    public TextField txtRemorcadeleted;
    public TextField txtNrnmatriculare;
    public TextField txtMasaUtila;
    public TextField txtMasaMaxima;
    public TextField txtModel;
    public Label lblNrInmatriculare;
    public Label lblMasaUtile;
    public Label lblMasaMaxima;
    public Label lblModel;
    public Button btnSaveRemorca;
    public TextField txtNrnmatriculareRem;
    public TextField txtMasaUtilaRem;
    public TextField txtMasaMaximaRem;
    public TextField txtModelRem;
    public Tab tabAdaugRemorca;
    public MenuItem menuItemUpdateRemorca;
    public ComboBox comboCNPClientUpdate;
    public Label lblCNPClientUpdate;
    public Label lblNumeClientUpdate;
    public Label lblPrenumeClientUpdate;
    public TextField txtNumeClientUpdate;
    public TextField txtPrenumeClientUpdate;
    public TextField txtTelActualClient;
    public Button btnUpdateClient;
    public Label lblTelactualClient;
    public TextField txtTelClientUpdated;
    public AnchorPane tabAnchorPaneUpdateClientandOwner;
    public Tab tabAddOwner;
    public Label lblOwnerName;
    public Label lblOwnerSurname;
    public Label lblOwnerCity;
    public Label lblOwnerStreet;
    public Label lblOwnerHouseNr;
    public Label lblOwnerBI;
    public Label lblOwnerCNP;
    public Label lblOwnerPhone;
    public TextField txtOwnerName;
    public TextField txtOwnerSurname;
    public TextField txtOwnerCity;
    public TextField txtOwnerStreet;
    public TextField txtOwnerHouseNr;
    public TextField txtOwnerBI;
    public TextField txtOwnerCNP;
    public TextField txtAddOwnerPhone;
    public Button btnSaveOwnerMySQL;
    public Tab tabUpdateOwner;
    public MenuItem menuItemUpdateOwner;
    public AnchorPane tabAnchorPaneUpdateOwner;
    public ComboBox comboCNPOwnerUpdate;
    public Label lblCNPOwnerpdate;
    public Label lblNumeOwnerUpdate;
    public Label lblPrenumeOwnerUpdate;
    public TextField txtNumeOwnerUpdate;
    public TextField txtPrenumeOwnerUpdate;
    public TextField txtTelActualOwner;
    public Button btnUpdateTelOwner;
    public Label lblTelactualOwner;
    public Label lblNewPhoneOwner;
    public TextField txtTelOwnerUpdated;
    public Label lblNewStreetOwner;
    public TextField txtNewStreetOwnerName;
    public Button btnUpdateStreetlOwner;
    public TextField txtNewHouseNrOwnerName;
    public Label lblNewHouseNrOwner;
    public Button btnUpdateHouseNrOwner;
    public TextField txtNewBIOwnerName;
    public Label lblNewBIOwner;
    public Button btnUpdateBIOwner;
    public TextField txtNewCityOwnerName;
    public Label lblNewCityOwner;
    public Button btnUpdateCityIOwner;
    public TextField txtStreetCleintUpdate;
    public TextField txtHousNrCllientUpdate;
    public TextField txtBICllientUpdate;
    public TextField txtCityCllientUpdate;
    public Label lblStreetClient;
    public TextField txtStreetClient;
    public Label lblCityClient;
    public TextField txtCityClient;
    public Label lblHouseNrClient;
    public TextField txtHouseNrClient;


    private boolean isLoggedIn = false;

    @Autowired
    private RemorcaRepository remorcaRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private AntreprenorRepository antreprenorRepository;

    @Autowired
    public Controller(RemorcaRepository remorcaRepository, ClientRepository clientRepository, CarRepository carRepository, AntreprenorRepository antreprenorRepository) {
        this.remorcaRepository = remorcaRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.antreprenorRepository = antreprenorRepository;
    }

    public void initialize() {
        tabPane.getTabs().remove(tabMain);
        tabPane.getTabs().remove(tabLogin);
        tabPane.getTabs().remove(tabAdaugClient);
        tabPane.getTabs().remove(tabAdaugCar);
        tabPane.getTabs().remove(tabDeleteCar);
        tabPane.getTabs().remove(tabUpdateClientandOwner);
        tabPane.getTabs().remove(tabDeleteREmorca);
        tabPane.getTabs().remove(tabAdaugRemorca);
        tabPane.getTabs().remove(tabAddOwner);
        tabPane.getTabs().remove(tabUpdateOwner);
    }


    public void loginUser(ActionEvent actionEvent) {
        if (txtfieldUserName.getText().equals(Constants.USERNAME)) {
            lblName.setTextFill(Color.BLACK);
            System.out.println(txtfieldUserName.getText());
        } else {
            lblName.setTextFill(Color.RED);
        }

        if (pswfield.getText().equals(Constants.PASSWORD)) {
            lblPasswaor.setTextFill(Color.BLACK);
            System.out.println(pswfield.getText());
        } else {
            lblPasswaor.setTextFill(Color.RED);
        }
        if (lblName.getTextFill().equals(Color.BLACK) && lblPasswaor.getTextFill().equals(Color.BLACK)) {
            tabPane.getTabs().add(tabMain);
            tabPane.getTabs().remove(tabLogin);
            isLoggedIn = true;
        }

    }

    public void openLogInWindow(ActionEvent actionEvent) {
        tabPane.getTabs().add(tabLogin);
    }

    public void logoutUser(ActionEvent actionEvent) {
        tabPane.getTabs().clear();
        isLoggedIn = false;
    }


    public void bringfromMySql(KeyEvent keyEvent) {
        comboBoxCarNumber.getItems().clear();
        if (comboBoxCarNumber.getEditor().getText().length() >= 2) {
            List<Remorca> remorcaList = remorcaRepository.findByCarNumberContaining(comboBoxCarNumber.getEditor().getText());

            comboBoxCarNumber.getItems()
                    .addAll(remorcaList);
            comboBoxCarNumber.show();
        }
    }

    public void getSelectedRemorca(ActionEvent actionEvent) {
        if (comboBoxCarNumber.getSelectionModel().getSelectedIndex() != -1) {
            Remorca remorca = (Remorca) comboBoxCarNumber.getSelectionModel().getSelectedItem();
            txtFieldCarNumber.setText(remorca.getCarNumber());
            txtFieldMaxWeigth.setText(String.valueOf(remorca.getMasa_Maxima()));
            txtFieldUtilWeigth1.setText(String.valueOf(remorca.getMasa_Utila()));
        }
    }

    public void openTabAddClient(ActionEvent actionEvent) {
        if (isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabAdaugClient);
        }
    }

    public void saveClient(ActionEvent actionEvent) {
        Client client = new Client();
        client.setC_Nume(txtNumeClient.getText());
        client.setC_Prenume(txtPrenumeClient.getText());
        client.setSerie_Buletin(txtSerieBuletin.getText());
        client.setCnp(txtCNPClient.getText());
        client.setC_nr_Telefon(txtTelClient.getText());
        client.setC_City(txtCityClient.getText());
        client.setC_House_nr(txtHouseNrClient.getText());
        client.setC_Street(txtStreetClient.getText());
        clientRepository.save(client);

        txtNumeClient.clear();
        txtPrenumeClient.clear();
        txtSerieBuletin.clear();
        txtCNPClient.clear();
        txtTelClient.clear();
        txtCityClient.clear();
        txtHouseNrClient.clear();
        txtStreetClient.clear();
    }

    public void saveCar(ActionEvent actionEvent) {
        Car car = new Car();
        car.setNr_Inmatriculare(txtCarNumber.getText());
        car.setNr_Identificare(txtCarRegNr.getText());
        car.setModel(txtCarOem.getText());
        carRepository.save(car);

        txtCarNumber.clear();
        txtCarRegNr.clear();
        txtCarOem.clear();

    }

    public void openTabAddCar(ActionEvent actionEvent) {
        if (isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabAdaugCar);
        }

    }

    public void bringfromMySqlClient(KeyEvent keyEvent) {
        comboBoxClientCNP.getItems().clear();
        if (comboBoxClientCNP.getEditor().getText().length() >= 2) {
            List<Client> clientList = clientRepository.findByCnpContaining(comboBoxClientCNP.getEditor().getText());

            comboBoxClientCNP.getItems()
                    .addAll(clientList);
            comboBoxClientCNP.show();
        }
    }

    public void getSelectedClient(ActionEvent actionEvent) {
        if (comboBoxClientCNP.getSelectionModel().getSelectedIndex() != -1) {
            try {
                Client client = (Client) comboBoxClientCNP.getSelectionModel().getSelectedItem();
                txtCNPClient.setText(client.getCnp());
                txtFieldClientSurname.setText(String.valueOf(client.getC_Prenume()));
                txtFieldNumeClient.setText(String.valueOf(client.getC_Nume()));
            } catch (Exception ex) {
                System.out.println("Something wrong");
            }
        }
    }

    public void openTabDeleteRemorca(ActionEvent actionEvent) {
        if (isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabDeleteREmorca);
        }
    }

    public void getSelectedRemorcaforDelete(ActionEvent actionEvent) {
        if (cmbCartoDelete.getSelectionModel().getSelectedIndex() != -1) {
            try {
                Remorca remorca = (Remorca) cmbCartoDelete.getSelectionModel().getSelectedItem();
                txtRemorcadeleted.setText(remorca.getCarNumber());
            } catch (Exception ex) {
                System.out.println("Something wrong");
            }
        }
    }


    public void bringfromMySqlforDelete(KeyEvent keyEvent) {
        cmbCartoDelete.getItems().clear();
        if (cmbCartoDelete.getEditor().getText().length() >= 2) {
            List<Remorca> remorcaList = remorcaRepository.findByCarNumberContaining(cmbCartoDelete.getEditor().getText());

            cmbCartoDelete.getItems()
                    .addAll(remorcaList);
            cmbCartoDelete.show();

        }
    }

    public void deleteRemorcaByNrImatriculare(ActionEvent actionEvent) {
        Remorca remorca = (Remorca) cmbCartoDelete.getSelectionModel().getSelectedItem();
        cmbCartoDelete.getItems().clear();
        remorcaRepository.delete(remorca);

        txtRemorcadeleted.clear();


    }

    public void saveRemorcainMySQL(ActionEvent actionEvent) {
        Remorca remorca = new Remorca();
        remorca.setCarNumber(txtNrnmatriculareRem.getText());
        remorca.setModel(txtModelRem.getText());
        remorca.setMasa_Maxima(txtMasaMaximaRem.getText());
        remorca.setMasa_Utila(txtMasaUtilaRem.getText());
        remorcaRepository.save(remorca);
    }

    public void openTabAddRemorca(ActionEvent actionEvent) {
        if (isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabAdaugRemorca);
        }
    }

    public void updateClient(ActionEvent actionEvent) {
        Client client = (Client) comboCNPClientUpdate.getSelectionModel().getSelectedItem();

        client.setC_Nume(txtNumeClientUpdate.getText());
        client.setC_Prenume(txtPrenumeClientUpdate.getText());

        client.setC_nr_Telefon(txtTelActualClient.getText());
        client.setC_Street(txtStreetCleintUpdate.getText());
        client.setC_House_nr(txtHousNrCllientUpdate.getText());
        client.setSerie_Buletin(txtBICllientUpdate.getText());
        client.setC_City(txtCityCllientUpdate.getText());

        clientRepository.save(client);

    }

    public void openTabUpdateClientandOwner(ActionEvent actionEvent) {
        if(isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabUpdateClientandOwner);
        }
    }

    public void selectClientUpdateTel(ActionEvent actionEvent) {

        System.out.println(actionEvent.getEventType());
        if (comboCNPClientUpdate.getSelectionModel().getSelectedIndex() != -1) {

            Client client = (Client) comboCNPClientUpdate.getSelectionModel().getSelectedItem();

            txtNumeClientUpdate.setText(client.getC_Nume());
            txtPrenumeClientUpdate.setText(String.valueOf(client.getC_Prenume()));

            txtTelActualClient.setText(String.valueOf(client.getC_nr_Telefon()));
            txtStreetCleintUpdate.setText(client.getC_Street());
            txtHousNrCllientUpdate.setText(client.getC_House_nr());
            txtBICllientUpdate.setText(client.getSerie_Buletin());
            txtCityCllientUpdate.setText(client.getC_City());
        }

    }

    public void bringMySQLCNPClinetforTelupdate(KeyEvent keyEvent) {
        comboCNPClientUpdate.getItems().clear();
        if (comboCNPClientUpdate.getEditor().getText().length() >= 2) {
            List<Client> clientList = clientRepository.findByCnpContaining(comboCNPClientUpdate.getEditor().getText());

            comboCNPClientUpdate.getItems()
                    .addAll(clientList);
            comboCNPClientUpdate.show();

        }
    }

    public void saveOwnerinMySQL(ActionEvent actionEvent) {
        Antreprenor antreprenor = new Antreprenor();
        antreprenor.setA_nume(txtOwnerName.getText());
        antreprenor.setA_prenume(txtOwnerSurname.getText());
        antreprenor.setA_telefon(txtAddOwnerPhone.getText());
        antreprenor.setCnp(txtOwnerCNP.getText());
        antreprenor.setSerie_Buletin(txtOwnerBI.getText());
        antreprenor.setStrada(txtOwnerStreet.getText());
        antreprenor.setA_nr_Casa(txtOwnerHouseNr.getText());
        antreprenor.setA_city(txtOwnerCity.getText());
        antreprenorRepository.save(antreprenor);
        txtOwnerName.clear();
        txtOwnerSurname.clear();
        txtAddOwnerPhone.clear();
        txtOwnerCNP.clear();
        txtOwnerBI.clear();
        txtOwnerStreet.clear();
        txtOwnerHouseNr.clear();
        txtOwnerCity.clear();
    }

    public void openTabAddOwner(ActionEvent actionEvent) {
        if(isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabAddOwner);
        }
    }

    public void selectOwnerUpdateTel(ActionEvent actionEvent) {
        System.out.println(actionEvent.getEventType());
        if (comboCNPOwnerUpdate.getSelectionModel().getSelectedIndex() != -1) {

            Antreprenor antreprenor = (Antreprenor) comboCNPOwnerUpdate.getSelectionModel().getSelectedItem();

            txtNumeOwnerUpdate.setText(antreprenor.getA_nume());
            txtPrenumeOwnerUpdate.setText(String.valueOf(antreprenor.getA_prenume()));
            txtTelActualOwner.setText(String.valueOf(antreprenor.getA_telefon()));
            txtNewStreetOwnerName.setText(antreprenor.getStrada());
            txtNewHouseNrOwnerName.setText(antreprenor.getA_nr_Casa());
            txtNewBIOwnerName.setText(antreprenor.getSerie_Buletin());
            txtNewCityOwnerName.setText(antreprenor.getA_city());
        }

    }


    public void bringMySQLCNPOwnerForTelupdate(KeyEvent keyEvent) {
        comboCNPOwnerUpdate.getItems().clear();
        if (comboCNPOwnerUpdate.getEditor().getText().length() >= 2) {
            List<Antreprenor> ownerList = antreprenorRepository.findByCnpContaining(comboCNPOwnerUpdate.getEditor().getText());

            comboCNPOwnerUpdate.getItems()
                    .addAll(ownerList);

            comboCNPOwnerUpdate.show();

        }
    }

    public void updateOwner(ActionEvent actionEvent) {
        Antreprenor antreprenor = (Antreprenor) comboCNPOwnerUpdate.getSelectionModel().getSelectedItem();

        antreprenor.setA_nume(txtNumeOwnerUpdate.getText());
        antreprenor.setA_prenume(txtPrenumeOwnerUpdate.getText());
        antreprenor.setA_telefon(txtTelActualOwner.getText());
        antreprenor.setStrada(txtNewStreetOwnerName.getText());
        antreprenor.setA_nr_Casa(txtNewHouseNrOwnerName.getText());
        antreprenor.setSerie_Buletin(txtNewBIOwnerName.getText());
        antreprenor.setA_city(txtNewCityOwnerName.getText());

        antreprenorRepository.save(antreprenor);

    }

    public void openTabUpdateOwner(ActionEvent actionEvent) {
        if(isLoggedIn) {
            tabPane.getTabs().clear();
            tabPane.getTabs().add(tabUpdateOwner);
        }
    }

    public void generateContract(ActionEvent actionEvent) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("e:\\iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, BaseColor.BLACK);
        Chunk chunk = new Chunk("CONTRACT DE INCHIRIERE VEHICUL\n", font);
        Paragraph para1 = new Paragraph(chunk);
        para1.setAlignment(Paragraph.ALIGN_CENTER);



        chunk = new Chunk("Nr.______/______________/Ora:__________\n");
        para1.add(chunk);
        document.add(para1);

        font = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
        chunk = new Chunk("(1) Predarea-primirea vehiculului inchiriat se va face la termenul convenit de parti, dupa semnarea prezentului contract si va fi consemnata in procesul verbal de predare-primire care constituie Anexa nr.2 la prezentul contract si face parte integranta din acesta.\n" +
                "(2) Vehiculul se pune la dispozitia Locatarului impreuna cu talonul, politele de asigurare si condițile generale și speciale aferente acestora si toate celelalte dotari corespunzatoare, ce vor fi inventariate in procesul verbal de predare-primire. Vehiculul intruneste toate conditiile tehnice de folosire, fiind in stare normala de functionare si neavand defectiuni si lipsuri.\n" +
                "(3) Locul predarii-primirii vehiculului este la punctul de lucru a locatorului. Locatarul poate sa returneze vehiculul la locul in care l-a primit, sau in orice alta locatie indicata de Locator.   \n",
                font);
        para1 = new Paragraph(chunk);
        para1.setAlignment(Paragraph.ALIGN_JUSTIFIED);

        document.add(para1);
        document.close();
    }
}

