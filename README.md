# HEALTH SAFETY

```mermaid
sequenceDiagram
    participant W as Wearable Device
    participant D as Doctor Dashboard
    participant IS as Ingestion Service
    participant JS as JMS telemetry 
    participant AS as Alert & Notification Service
    
    W->>IS: POST /api/v1/readings
    IS->>JS: Publish heart rate reading event
    IS-->>W: 202 Accepted
    
    

