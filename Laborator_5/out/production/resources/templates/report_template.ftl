<!DOCTYPE html>
<html>
<head>
    <title>Raport Documente</title>
    <style>
        /* Stiluri CSS pentru formatarea tabelului */
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Raport Documente</h1>
    <table>
        <tr>
            <th>Folder</th>
            <th>Documente</th>
        </tr>
        <#list foldersAndDocuments as person, documents>
            <tr>
                <td>${person.name()}_${person.id()}</td>
                <td>
                    <ul>
                        <#list documents as document>
                            <li>${document.name() + '.' + document.format()}</li>
                        </#list>
                    </ul>
                </td>
            </tr>
        </#list>
    </table>
</body>
</html>
