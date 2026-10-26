# HEALTH SAFETY

Health safety is an application that sends patient alerts and doctors can assist
them through the system. Keeps track of patient temperature and how track record on the
last message and response.





```mermaid
sequenceDiagram
    participant W as Wearable Device
    participant IS as Ingestion Service
    participant JS as JMS telemetry 
    participant AS as Alert & Notification Service
    participant D as Doctor Dashboard
    
   %% Phase A: Ingestion (Non-Blocking)
    W->>IS: POST /api/v1/readings
    IS->>JS: Publish heart rate reading event
    IS-->>W: 202 Accepted
    
    %% Phase B: Event Evaluation & Notification
    JS->>AS: Deliver telemetry JSON Message
    Note over AS: Check BPM vs Cached Baseline
     
    %% opt Spike Detected (BPM > BaseLine)
    AS->>D: PUSH Alert Event (SSE Stream)
    D->>AS: POST  /api/v1/alerts/{id}/acknowledge
    AS-->>D: 200 ok
    
```


ONE TIME PIN: WTC-ML5R2WUG

### Database 

```mermaid
   erDiagram

    Patient }o--|| allocated_doctor : patient doctor
    Doctor }o--|| allocated_doctor : doctors patient
    allocated_doctor}o--|| alert_doctor : send message

    Patient {
           ID uuid
           firstname varchar
           lastname varchar
           ThreTemp float
       }
       
       Doctor{
           id uuid Primary key
           firstname varchar
           lastname varchar
           department varchar
       }
       
       
        alert_doctor{
            ID int Primary key
            allocated_doctor_id int fk
            symptoms varchar
            temperature float
            datetime created_at
        }
        
        allocated_doctor{
            ID int primary key
            patient_id uuid fk
            doctor_id uuid fk
        }
        
```

