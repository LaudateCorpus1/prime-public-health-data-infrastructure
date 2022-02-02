import os
from dataclasses import dataclass


@dataclass
class IngestSettings:
    hostname = os.environ.get("VDHSFTPHostname")
    username = os.environ.get("VDHSFTPUsername")
    password = os.environ.get("VDHSFTPPassword")
    connection_string = os.environ.get("AZURE_STORAGE_CONNECTION_STRING")