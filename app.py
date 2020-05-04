from flask import Flask,render_template
from flask import request
from sklearn.externals import joblib
import pandas as pd

import os

Path = os.getcwd()
pa_fact_model = joblib.load(Path + "/PA/factorization.sav")
qc_fact_model = joblib.load(Path + "/QC/factorization.sav")
ab_fact_model = joblib.load(Path + "/AB/factorization.sav")
wi_fact_model = joblib.load(Path + "/WI/factorization.sav")
nc_fact_model = joblib.load(Path + "/NC/factorization.sav")
oh_fact_model = joblib.load(Path + "/OH/factorization.sav")

print('factorization models loaded!')

pa_train_data = joblib.load(Path + "/PA/train_data.sav")
qc_train_data = joblib.load(Path + "/QC/train_data.sav")
ab_train_data = joblib.load(Path + "/AB/train_data.sav")
wi_train_data = joblib.load(Path + "/WI/train_data.sav")
nc_train_data = joblib.load(Path + "/NC/train_data.sav")
oh_train_data = joblib.load(Path + "/OH/train_data.sav")

print('training data loaded!')

columns = ['item_id']
pa_items = pd.DataFrame(pd.read_csv(Path + "/PA/fact_dataset.csv").item_id.unique(), columns = columns)
qc_items = pd.DataFrame(pd.read_csv(Path + "/QC/fact_dataset.csv").item_id.unique(), columns = columns)
ab_items = pd.DataFrame(pd.read_csv(Path + "/AB/fact_dataset.csv").item_id.unique(), columns = columns)
wi_items = pd.DataFrame(pd.read_csv(Path + "/WI/fact_dataset.csv").item_id.unique(), columns = columns)
nc_items = pd.DataFrame(pd.read_csv(Path + "/NC/fact_dataset.csv").item_id.unique(), columns = columns)
oh_items = pd.DataFrame(pd.read_csv(Path + "/OH/fact_dataset.csv").item_id.unique(), columns = columns)

print('datasets loaded!')

app = Flask(__name__)
@app.route('/predict', methods=['GET'])
def predict():
    user = request.args.get('user')
    state = request.args.get('state')

    train_data = None
    loaded_model = None
    items = None

    if state == 'PA':
        train_data = pa_train_data
        loaded_model = pa_fact_model
        items = pa_items
    elif state == 'QC':
        train_data = qc_train_data
        loaded_model = qc_fact_model
        items = qc_items
    elif state == 'AB':
        train_data = ab_train_data
        loaded_model = ab_fact_model
        items = ab_items
    elif state == 'WI':
        train_data = wi_train_data
        loaded_model = wi_fact_model
        items = wi_items
    elif state == 'NC':
        train_data = nc_train_data
        loaded_model = nc_fact_model
        items = nc_items
    else: #if state == 'OH':
        train_data = oh_train_data
        loaded_model = oh_fact_model
        items = oh_items

    uid = train_data.to_inner_uid(user)

    def predict(x):
        try:
            iid = train_data.to_inner_iid(x.item_id)
            return loaded_model.predict(str(uid),str(iid)).est
        except:
            return -1

    items['rating'] = items.apply(lambda x: predict(x), axis=1)
    result = items.sort_values(by=['rating'],ascending=False).head(10)
    result = result.drop(columns=['rating'])

    return result.to_json(orient='values')
